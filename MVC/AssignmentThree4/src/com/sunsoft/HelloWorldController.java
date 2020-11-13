package com.sunsoft;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/login")
	public String helloWorld(HttpServletRequest request, HttpServletResponse res,Model m) {
		String name1 = request.getParameter("name1");
		String password1 = request.getParameter("password1");

		String name2 = request.getParameter("name2");
		String password2 = request.getParameter("password2");

		String name3 = request.getParameter("name3");
		String password3 = request.getParameter("password3");

		String name4 = request.getParameter("name4");
		String password4 = request.getParameter("password4");

		ArrayList<String> l1 = new ArrayList<String>();
		l1.add(name1);
		l1.add(password1);
		ArrayList<String> l2 = new ArrayList<String>();
		l2.add(name2);
		l2.add(password2);
		ArrayList<String> l3 = new ArrayList<String>();
		l3.add(name3);
		l3.add(password3);
		ArrayList<String> l4 = new ArrayList<String>();
		l4.add(name4);
		l4.add(password4);//

		ArrayList<List<String>> list = new ArrayList<>();
		list.add(l1);
		list.add(l2);
		list.add(l3);
		list.add(l4);
		
		m.addAttribute("list",list);
		return "hellopage";

//		return new ModelAndView("errorpage", "message", "Sorry, username or password error");
	}

}