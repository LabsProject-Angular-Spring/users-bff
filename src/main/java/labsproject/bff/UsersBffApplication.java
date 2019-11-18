package labsproject.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UsersBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersBffApplication.class, args);
	}

}
