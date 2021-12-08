package train.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
//@RestController
//@RequestMapping("/trainservice")
public class TrainServiceApplication {
	
//	@GetMapping("/train")
//	public String show() {
//		return "Hello World";
//	}

	public static void main(String[] args) {
		SpringApplication.run(TrainServiceApplication.class, args);
	}

}
