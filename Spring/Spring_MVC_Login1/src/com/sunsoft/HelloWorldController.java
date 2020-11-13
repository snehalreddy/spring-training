package com.sunsoft;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class HelloWorldController {
	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest request,HttpServletResponse res,Model m) {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		if(password.equals("admin")) {
			String message="You are a valid user, Welcome "+name;
			m.addAttribute("message",message);
			return "hellopage";
		}
		else {
			m.addAttribute("message","Sorry, username or password error");
			return "errorpage";
		}
	}
	

}
