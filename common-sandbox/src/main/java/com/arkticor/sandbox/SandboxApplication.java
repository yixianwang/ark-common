package com.arkticor.sandbox;

import com.arkticor.service.CommonService; // Import from your library

import lombok.CustomLog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@CustomLog
@SpringBootApplication
public class SandboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandboxApplication.class, args);
	}

	// Trigger your library code on startup to test it
	@Bean
	public CommandLineRunner runTest(CommonService commonService) {
		return args -> {
			String result = commonService.processData("Hello Debugger");
			log.info(">>>>>>{}", "test");
			System.out.println("Library Result: " + result);
		};
	}
}