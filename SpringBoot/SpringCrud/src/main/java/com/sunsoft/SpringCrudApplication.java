package com.sunsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sunsoft.controller", "com.sunsoft.repository", "com.sunsoft.dao",
		"com.sunsoft.model" })
public class SpringCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCrudApplication.class, args);
	}
}
