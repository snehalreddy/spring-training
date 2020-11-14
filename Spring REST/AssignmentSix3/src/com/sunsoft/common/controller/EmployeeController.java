package com.sunsoft.common.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

// URL: http://localhost:8080/HelloREST/payroll/INSERT_ID_HERE

@RestController
@RequestMapping("/payroll")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMovie(@RequestParam String firstName, @RequestParam String lastName) {

		String fullName = firstName + " " + lastName;
		
//		return emp.toString();
		return new Gson().toJson(fullName);
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name) {
		System.out.println(name);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
