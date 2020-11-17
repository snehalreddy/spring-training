package com.sunsoft.AngularIntegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sunsoft.controller"})
public class AngularIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularIntegrationApplication.class, args);
	}

}
