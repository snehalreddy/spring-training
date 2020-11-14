package com.sunsoft.common.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sunsoft.common.model.ElectricityBill;

// URL: http://localhost:8080/HelloREST/payroll/INSERT_ID_HERE

@RestController
@RequestMapping("/payroll")
public class EmployeeController {
	ArrayList<ElectricityBill> ebList = new ArrayList<ElectricityBill>();
	
	public EmployeeController() {
		ElectricityBill eb1 = new ElectricityBill(1, "John Doe", 50, 4, 200, "10th OCT 2020");
		ElectricityBill eb2 = new ElectricityBill(2, "John Doe", 150, 4, 600, "1st JAN 2021");
		ElectricityBill eb3 = new ElectricityBill(3, "John Doe", 500, 4, 2000, "10th DEC 2020");
		ElectricityBill eb4 = new ElectricityBill(4, "John Doe", 100, 4, 400, "6th OCT 2020");
		ElectricityBill eb5 = new ElectricityBill(5, "John Doe", 550, 10, 5500, "10th NOV 2020");
		
		this.ebList.add(eb1);
		this.ebList.add(eb2);
		this.ebList.add(eb3);
		this.ebList.add(eb4);
		this.ebList.add(eb5);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getMovie(@RequestParam int meterNo) {
		ElectricityBill eb = this.ebList.get(meterNo);
		
//		return emp.toString();
		return new Gson().toJson(eb);
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name) {
		System.out.println(name);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
