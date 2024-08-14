package com.surfeillance.surfeillanceV2_backend;

import com.surfeillance.surfeillanceV2_backend.model.Spot;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAO;
import com.surfeillance.surfeillanceV2_backend.service.api.waves.WavesDAOimpl;
import com.surfeillance.surfeillanceV2_backend.service.logic.ForecastService;
import com.surfeillance.surfeillanceV2_backend.service.logic.ForecastServiceImpl;
import com.surfeillance.surfeillanceV2_backend.util.DateTimeParserUtil;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.surfeillance.surfeillanceV2_backend"})
@EnableScheduling
public class SurfeillanceV2BackendApplication {


	public static void main(String[] args) {

		SpringApplication.run(SurfeillanceV2BackendApplication.class, args);
		runDemo();

	}

	@Autowired
	private DateTimeParserUtil dateTimeParserUtil;

	public void runDemo() {
		String dateTime = "2024-07-26T16:30";
		System.out.println("Parsed Date: " + dateTimeParserUtil.parseDate(dateTime));
		System.out.println("Parsed Time: " + dateTimeParserUtil.parseTime(dateTime));
	}
}

