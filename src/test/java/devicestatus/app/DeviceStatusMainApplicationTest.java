package devicestatus.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import devicestatus.service.DeviceStatusService;

@SpringBootTest
class DeviceStatusMainApplicationTest {

	private DeviceStatusService deviceStatusService = mock(DeviceStatusService.class);

	@Test
	void contextLoads() {
		assertThat(deviceStatusService).isNotNull();
	}

}
