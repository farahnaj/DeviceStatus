package devicestatus.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"devicestatus"} )
public class DeviceStatusMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeviceStatusMainApplication.class, args);
	}

}
