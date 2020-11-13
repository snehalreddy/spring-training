package com.sunsoft;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/login")
	public ModelAndView helloWorld (HttpServletRequest request, HttpServletResponse res) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if (password.equals("admin")) {
			String message = "You are a valid user, Welcome " + name;
			return new ModelAndView("hellopage", "message", message);
		} else {
			return new ModelAndView("errorpage", "message", "Sorry, username or password error");
		}
	}
	
}