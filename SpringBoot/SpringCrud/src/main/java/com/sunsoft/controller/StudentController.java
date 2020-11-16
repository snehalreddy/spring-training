package com.sunsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunsoft.dao.StudentDao;
import com.sunsoft.model.StudentData;

@RestController
public class StudentController {
	@Autowired
	StudentDao studentDao;

	@RequestMapping("/insert")
	public String insertData() {
		StudentData studentObj = new StudentData();
		studentObj.setId(11);
		studentObj.setName("Snehal Reddy");
		studentObj.setMarks(75);
		studentObj.setDept("CS");

		StudentData studentObj2 = new StudentData();
		studentObj2.setId(25);
		studentObj2.setName("Onyx");
		studentObj2.setMarks(100);
		studentObj2.setDept("CSE");

		studentDao.insertData(studentObj);
		studentDao.insertData(studentObj2);
		return "Data inserted succesfully";

	}

	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") int id) {
		studentDao.deleteRecord(id);
		return "Record deleted successfully";
	}

	@RequestMapping("/displayAll")
	public List<StudentData> displayData() {
		List<StudentData> studentList = studentDao.displayAll();
		return studentList;
	}

}
