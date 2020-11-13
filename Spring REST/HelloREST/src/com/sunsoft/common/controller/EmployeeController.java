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
	public String getMovie(@RequestParam int empId) {
		HashMap<Integer, Employee> hml = new HashMap<Integer, Employee>();

		hml.put(1, new Employee(1, "John Doe", 55000, 3500, 2000, 200));
		hml.put(2, new Employee(2, "Jane Doe", 55000, 3500, 2000, 200));
		hml.put(3, new Employee(3, "Rick Grimes", 65000, 3500, 2000, 200));

		Employee emp = null;
		if (hml.containsKey(empId)) {
			emp = hml.get(empId);
		}

		emp.setGross_sal(emp.getBasic() + emp.getHra() + emp.getAllowance());
		emp.setFinal_deductions((int) (emp.getDeductions() + emp.getGross_sal() * 0.2));
		emp.setTotal_sal(emp.getGross_sal() - emp.getFinal_deductions());

//		return emp.toString();
		return new Gson().toJson(emp);
	}

	@RequestMapping(value = "/display", method = RequestMethod.POST)
	public ResponseEntity<String> createEmployee(@RequestBody String name) {
		System.out.println(name);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
}
