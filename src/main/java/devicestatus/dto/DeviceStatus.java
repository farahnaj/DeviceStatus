package devicestatus.dto;

import java.time.Instant;

// Lombok does not work well with Jackson. Hence explicitly adding getters/setters and constructors
// This fails only during integration test 
public class DeviceStatus {

    public enum Health{
        OK,
        WARNING,
        ERROR
    }

    private Integer id;
    private String message;
    private Health health;
    private Integer deviceId;
    private Instant createdOn;

    public DeviceStatus(Integer id, String message, Health health, Integer deviceId, Instant createdOn) {
        this.id = id;
        this.message = message;
        this.health = health;
        this.deviceId = deviceId;
        this.createdOn = createdOn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHealth() {
        return health.name();
    }

    public void setHealth(String health) {
        this.health = Health.valueOf(health);
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return String.format("[DeviceStatus Id:%d, message:%s, health:%s, deviceId:%s, CreatedOn:%s]", id, message, health, deviceId, createdOn.toString());
    }
}
