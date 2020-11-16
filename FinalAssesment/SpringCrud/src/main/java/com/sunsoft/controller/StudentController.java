package com.sunsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.StudentDao;
import com.sunsoft.dao.UserDao;
import com.sunsoft.model.StudentData;
import com.sunsoft.model.User;

@RestController()
public class StudentController {
//	@Autowired
//	StudentDao studentDao;
	
	@Autowired
	UserDao userdao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestBody String body) {
		String name = body.split("&")[0].split("=")[1];
		String password = body.split("&")[1].split("=")[1];
		String res = "INVALID";
		
		if(userdao.SearchRecord(name, password)) {
			res = "VALID_USER";
		} 

		return res;//
	}
	
//	@RequestMapping("/insert")
//	public String insertData() {
//		StudentData studentObj = new StudentData();
//		studentObj.setId(11);
//		studentObj.setName("Snehal Reddy");
//		studentObj.setMarks(75);
//		studentObj.setDept("CS");
//
//		StudentData studentObj2 = new StudentData();
//		studentObj2.setId(25);
//		studentObj2.setName("Onyx");
//		studentObj2.setMarks(100);
//		studentObj2.setDept("CSE");
//
//		studentDao.insertData(studentObj);
//		studentDao.insertData(studentObj2);
//		return "Data inserted succesfully";
//
//	}
	
	@RequestMapping("/insertSampleUsers")
	public String insertSampleUsersData() {
		User user1 = new User();
		user1.setId(1);
		user1.setName("Onyx");
		user1.setPassword("password");
		
		User user2 = new User();
		user2.setId(2);
		user2.setName("Rick");
		user2.setPassword("pass");
		
		userdao.insertData(user1);
		userdao.insertData(user2);

		return "Data inserted succesfully";

	}
//	@RequestMapping("/delete/{id}")
//	public String deleteData(@PathVariable("id") int id) {
//		studentDao.deleteRecord(id);
//		return "Record deleted successfully";
//	}

//	@RequestMapping("/displayAll")
//	public List<StudentData> displayData() {
//		List<StudentData> studentList = studentDao.displayAll();
//		return studentList;
//	}

	@RequestMapping("/displayAllUsers")
	public List<User> displayUserData() {
		List<User> userList = userdao.displayAll();
		return userList;
	}
}
