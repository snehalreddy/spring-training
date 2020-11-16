package com.sunsoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("/test")
	public String testFuntion() {
		String str = "This is my first spring boot web application...";
		System.out.println("This is seen in console..");
		return str;
	}

}
