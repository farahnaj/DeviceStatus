package devicestatus.dto;

import java.time.LocalDate;
import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

//DataAccessObject
public interface DeviceStatusDao {
  @SqlQuery("select id,message,health,device_id,created_on from device_status where device_id=:deviceId")
  @RegisterBeanMapper(DeviceStatusMapper.class)
  List<DeviceStatus> getDeviceStatus(Integer deviceId);

  @SqlUpdate("INSERT INTO DEVICE_STATUS (id,message,health,device_id,created_on) VALUES(DEFAULT,?,?,?,?)")
  void insertPositional(String message, String health, Integer device_id,
      LocalDate date);
}
