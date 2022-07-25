package devicestatus.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import devicestatus.dto.DeviceStatus;
import devicestatus.service.DeviceStatusService;

class DeviceStatusControllerTest {

	private DeviceStatusService deviceStatusService;
	private DeviceStatusController controller;

	@BeforeEach
	void setup() {
		deviceStatusService = mock(DeviceStatusService.class);
		controller = new DeviceStatusController(deviceStatusService);
	}

	@Test
	void getDeviceStatus_getsHttpOk_withDeviceStatus() {
		DeviceStatus expectedStatus = new DeviceStatus(1, "blah", DeviceStatus.Health.OK, 2, Instant.EPOCH);
		when(deviceStatusService.getDeviceStatus(2)).thenReturn(List.of(expectedStatus));

		var result = controller.getDeviceStatus(2);

		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(result.getBody()).usingRecursiveComparison().isEqualTo(List.of(expectedStatus));
	}

	@Test
	void getDeviceStatus_forDeviceWithNoStatus_returnsHttpStatusNoContent() {
		when(deviceStatusService.getDeviceStatus(3)).thenReturn(List.of());

		var result = controller.getDeviceStatus(3);

		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
		assertThat(result.getBody()).isNull();
	}

	@Test
	void createDeviceStatus_createsDeviceStatus() {
		DeviceStatus expectedStatus = new DeviceStatus(1, "blah", DeviceStatus.Health.ERROR, 4, Instant.EPOCH);

		var result = controller.createDeviceStatus(expectedStatus);

		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
