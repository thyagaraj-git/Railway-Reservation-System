package user.service;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;


@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition
public class UserServiceApplication {
	
	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
