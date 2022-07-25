package devicestatus.service;
import java.util.List;
import devicestatus.dto.DeviceStatus;

/**
 * Device Status service.
 */
public interface DeviceStatusService {

    /**
     * Get all the statuses for the device
     *
     * @param deviceId the device id
     * @return the list of status
     */
    List<DeviceStatus> getDeviceStatus(Integer deviceId);

    /**
     * Create a new status
     * 
     * @param deviceStatus the {@link DeviceStatus} dto
     */
    void createDeviceStatus(DeviceStatus deviceStatus) throws Exception;
}
