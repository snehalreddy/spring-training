package com.sunsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = ("com.sunsoft.controller"))
public class SpringTest2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringTest2Application.class, args);
	}

}
