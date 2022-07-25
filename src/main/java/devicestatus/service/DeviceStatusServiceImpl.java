package devicestatus.service;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import devicestatus.dto.DeviceStatus;
import devicestatus.dto.DeviceStatusDao;
import devicestatus.dto.DeviceStatusMapper;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


/**
 * Business logic implementaiton for Device Status's Service.
 */
@Service
class DeviceStatusServiceImpl implements DeviceStatusService {

    Logger logger = LoggerFactory.getLogger(DeviceStatusServiceImpl.class);

    private final DatabaseService databaseService;
    private final Jdbi jdbi;

    DeviceStatusServiceImpl(DatabaseService databaseService, ObjectMapper objectMapper) {
        this.databaseService = databaseService;
        this.jdbi = this.databaseService.getJdbi();
        objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
    }

    @Override
    public List<DeviceStatus> getDeviceStatus(Integer deviceId) {
        jdbi.registerRowMapper(DeviceStatusMapper.build());
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi.withExtension(DeviceStatusDao.class, dao -> dao.getDeviceStatus(deviceId));
    }

    @Override
    public void createDeviceStatus(DeviceStatus deviceStatus) throws Exception {
        jdbi.registerRowMapper(DeviceStatusMapper.build());
        jdbi.installPlugin(new SqlObjectPlugin());
        jdbi.useExtension(DeviceStatusDao.class, dao -> dao.insertPositional(
                deviceStatus.getMessage(), deviceStatus.getHealth(), deviceStatus.getDeviceId(), LocalDate.now()));
    }
}
