package devicestatus.service;

import java.util.Date;
import java.util.List;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import devicestatus.dto.DeviceStatus;
import devicestatus.dto.DeviceStatusMapper;

public interface TestDbDao {
    @SqlUpdate("CREATE TABLE Device_Status (id integer PRIMARY KEY,message VARCHAR, health VARCHAR, device_id int8, created_on timestamp)")
    void createTable();

    @SqlUpdate("INSERT INTO Device_Status (id,message,health,device_id,created_on) VALUES(?,?,?,?,?)")
    void insertPositional(int id, String message, String health, int device_id, Date date);

    //TODO: Check this wasn't working hence used positional in service test.
    @SqlUpdate("INSERT INTO Device_Status (id,message,health,device_id,created_on) VALUES(:ticked_id,:title,:reporter,:assignee,:created_on)")
    void insertNamed(@Bind("id") int id, @Bind("message") String message,
            @Bind("health") String health, @Bind("device_id") int device_id,
            @Bind("created_on") Date date);

    @SqlQuery("select id,message,health,device_id from device_status where device_id=:device_id")
    @RegisterBeanMapper(DeviceStatusMapper.class)
    List<DeviceStatus> getDeviceStatus(Integer deviceId);
}
