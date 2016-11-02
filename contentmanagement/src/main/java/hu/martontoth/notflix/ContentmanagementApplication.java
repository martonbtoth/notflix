package hu.martontoth.notflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ContentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentmanagementApplication.class, args);
	}
}
