package com.sunsoft.common.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sunsoft.common.model.Employee;

// URL: http://localhost:8080/HelloREST/payroll/INSERT_ID_HERE

@RestController
@RequestMapping("/payroll")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String getMovie(@RequestParam String name, @RequestParam String password) {

		String res = "INVALID_USER";
		
		if(name.equals("admin") && password.equals("admin")) {
			res = "ADMIN";
		} else if(name.equals("snehal") && password.equals("snehal")) {
			res = "VALID_USER";
		} 

//		return emp.toString();
		return new Gson().toJson(res);
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name) {
		System.out.println(name);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
