package com.app.assurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BackEndGarantieProjectApplication {
	@RequestMapping("/")
	public String home() {
		return "Hello Hamza !!!!";
	}
	public static void main(String[] args) {
		SpringApplication.run(BackEndGarantieProjectApplication.class, args);
	}

}
