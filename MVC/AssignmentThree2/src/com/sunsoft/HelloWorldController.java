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
	public ModelAndView helloWorld (HttpServletRequest request, HttpServletResponse res, Model m) {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if (password.equals("admin")) {
			m.addAttribute("id", "5");
			m.addAttribute("name", "Snehal");
			m.addAttribute("dept", "IGBT");
			
			return new ModelAndView("hellopage");
		} else {
			return new ModelAndView("errorpage", "message", "Sorry, username or password error");
		}
	}
	
}