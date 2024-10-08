package com.surfeillance.surfeillanceV2_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.surfeillance.surfeillanceV2_backend"})
@EnableScheduling
public class SurfeillanceV2BackendApplication {


	public static void main(String[] args) {

		SpringApplication.run(SurfeillanceV2BackendApplication.class, args);

	}


}

