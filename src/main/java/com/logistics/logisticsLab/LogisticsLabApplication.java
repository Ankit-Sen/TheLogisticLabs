package com.logistics.logisticsLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.logistics.logisticsLab.model")
public class LogisticsLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticsLabApplication.class, args);
	}

}
