package devicestatus.controller;

import java.util.List;

import devicestatus.dto.DeviceStatus;
import devicestatus.errorhandler.exceptions.DeviceStatusCreationException;
import devicestatus.service.DeviceStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/devicestatus")
@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.PUT})
public class DeviceStatusController extends SpringBootServletInitializer {

    Logger log = LoggerFactory.getLogger(DeviceStatusController.class);

    private final DeviceStatusService deviceStatusService;

    public DeviceStatusController(DeviceStatusService service) {
        this.deviceStatusService = service;
    }

    // No value inside GetMapping here implies its the mapping on the controller
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DeviceStatus>> getDeviceStatus(@RequestParam Integer deviceId) {
        var statuses = deviceStatusService.getDeviceStatus(deviceId);
        if (!statuses.isEmpty()) {
            return ResponseEntity.ok(statuses);
        }
        return ResponseEntity.noContent().build();
    }

    // Mapping on controller + value
    @PutMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeviceStatus> createDeviceStatus(@RequestBody DeviceStatus deviceStatus) {
        try {
            deviceStatusService.createDeviceStatus(deviceStatus);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new DeviceStatusCreationException(e);
        }
    }
}
