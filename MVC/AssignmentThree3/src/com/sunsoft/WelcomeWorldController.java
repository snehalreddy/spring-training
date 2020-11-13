package com.sunsoft;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeWorldController {

	@RequestMapping("/welcome/{id1}")
	public String helloWorld(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("basic") String basic, @RequestParam("da") String da, @RequestParam("hra") String hra,
			@RequestParam("deductions") String deductions, @PathVariable("id1") int id1, Model m) {

		int sal = Integer.parseInt(basic) + Integer.parseInt(da) + Integer.parseInt(hra) - Integer.parseInt(deductions);
		String message = "Given data ID: " + id + "Name: " + name + " Salary: " + sal;
		m.addAttribute("message", message);
		m.addAttribute("test", "test");

		return "welcomepage";

	}

}
