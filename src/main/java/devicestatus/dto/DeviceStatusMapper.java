package devicestatus.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class DeviceStatusMapper implements RowMapper<DeviceStatus> {

    public static DeviceStatusMapper build() {
        return new DeviceStatusMapper();
    }

    @Override
    public DeviceStatus map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new DeviceStatus(rs.getInt("id"), rs.getString("message"),
                DeviceStatus.Health.valueOf(rs.getString("health")),
                rs.getInt("device_id"),rs.getTimestamp("created_on").toInstant());
    }
}
