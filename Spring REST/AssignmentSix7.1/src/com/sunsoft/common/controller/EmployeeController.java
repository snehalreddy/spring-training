package com.sunsoft.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin

import com.google.gson.Gson;

// URL: http://localhost:8080/HelloREST/payroll/INSERT_ID_HERE

@CrossOrigin
@RestController
@RequestMapping("/payroll")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.POST)
	public String getMovie(@RequestBody String body) {

		
		String name = body.split("&")[0].split("=")[1];
		String password = body.split("&")[1].split("=")[1];
		
		String res = "INVALID_USER";

		if (name.equals("admin") && password.equals("admin")) {
			res = "ADMIN";
		} else if (name.equals("snehal") && password.equals("snehal")) {
			res = "VALID_USER";
		} else if (name.equals("onyx") && password.equals("pass")) {
			res = "VALID_USER";
		}

//		return res.toString();
		return new Gson().toJson(res);
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name) {
		System.out.println(name);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
