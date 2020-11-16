package com.sunsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.InsuranceDao;
import com.sunsoft.dao.StudentDao;
import com.sunsoft.dao.UserDao;
import com.sunsoft.model.InsuranceData;
import com.sunsoft.model.StudentData;
import com.sunsoft.model.User;

@RestController()
public class StudentController {
//	@Autowired
//	StudentDao studentDao;
	
	@Autowired
	InsuranceDao userdao;
	
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
	
	@RequestMapping(value = "/insertSampleUser", method = RequestMethod.POST)
	public String insertSampleUsersData(@RequestBody String body) {
		int id = Integer.parseInt(body.split("&")[0].split("=")[1]);
		String name = body.split("&")[1].split("=")[1];
		String policy = body.split("&")[2].split("=")[1];
		
		InsuranceData user1 = new InsuranceData();
		user1.setId(id);
		user1.setName(name);
		user1.setPolicy(policy);
		
		userdao.insertData(user1);

		return "Data inserted succesfully";
	}

	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id)
	{
		userdao.deleteRecord(id);
		return "Record deleted successfully";
	}
	
	@RequestMapping(value = "/updateSampleUser", method = RequestMethod.POST)
	public String updateSampleUsersData(@RequestBody String body) {
		int id = Integer.parseInt(body.split("&")[0].split("=")[1]);
		
		deleteData(id);
		
		String name = body.split("&")[1].split("=")[1];
		String policy = body.split("&")[2].split("=")[1];
		
		InsuranceData user1 = new InsuranceData();
		user1.setId(id);
		user1.setName(name);
		user1.setPolicy(policy);
		
		userdao.insertData(user1);

		return "Data updated succesfully";
	}
	

	@RequestMapping("/displayAll")
	public List<InsuranceData> displayData() {
		List<InsuranceData> userList = userdao.displayAll();
		return userList;
	}

}
