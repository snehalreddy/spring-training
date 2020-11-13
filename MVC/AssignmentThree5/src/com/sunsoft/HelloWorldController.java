package com.sunsoft;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	private static SessionFactory factory;

	public static void getSessionFactory() {
		try {
			Configuration conf = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(conf.getProperties());
			factory = conf.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Falied to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
		@RequestMapping("/login")
	public String helloWorld(HttpServletRequest request, HttpServletResponse res, Model m) {
			String name = request.getParameter("name");
			String course = request.getParameter("course");
			
			ArrayList<List<String>> li = new ArrayList<List<String>>();
			ArrayList<String> li1=new ArrayList<String>();
			
			String message1 = "Name :" + name;
			String message2 = "Course :" + course;
			li1.add(message1);
			li1.add(message2);
			
			li.add(li1);
			
			m.addAttribute("lst", li);
		

			getSessionFactory();

			Session session = factory.openSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				
				
							
				session.save(lst);
				transaction.commit();

			
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		
		
		
		

		return "display";
	}
}