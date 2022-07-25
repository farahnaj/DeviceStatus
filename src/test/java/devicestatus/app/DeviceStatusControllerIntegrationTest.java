package devicestatus.app;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import devicestatus.dto.DeviceStatus;
import devicestatus.service.DeviceStatusService;

@WebMvcTest
public class DeviceStatusControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DeviceStatusService deviceStatusService;

    @Test
    void getDeviceStatus_getsHttpOk() throws Exception {
        DeviceStatus deviceStatus = new DeviceStatus(1, "blah", DeviceStatus.Health.OK, 2, Instant.EPOCH);
        String expectedDeviceStatus = "[{\"id\":1,\"message\":\"blah\",\"health\":\"OK\",\"deviceId\":2,\"createdOn\":\"1970-01-01T00:00:00Z\"}]";
        when(deviceStatusService.getDeviceStatus(2)).thenReturn(List.of(deviceStatus));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/devicestatus?deviceId=2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedDeviceStatus));
        verify(deviceStatusService).getDeviceStatus(any());
    }

    @Test
    void createDeviceStatus_wihtoutUserParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/devicestatus"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    void createDeviceStatus_createsDeviceStatus_getsHttpOk() throws Exception {
        String jsonContent = "{" +
                "\"deviceId\": 1 ,"+
                "\"message\": \"Login feature for the app\"," +
                "\"health\": \"OK\"" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/devicestatus/create")
                .contentType(MediaType.APPLICATION_JSON).content(jsonContent.getBytes()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        //verify(deviceStatusService).getDeviceStatus(any());
    }

    @Test
    void createDeviceStatus_wihtoutPutBody_throwsUnsupportedMediaType() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/devicestatus/create"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }
}
