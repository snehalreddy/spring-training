package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.StudentData;
import com.sunsoft.repository.StudentRepository;

@Service
public class StudentDao {
	@Autowired
	StudentRepository studentRepository;

	public void insertData(StudentData studentObj) {
		studentRepository.save(studentObj);
	}

	public void deleteRecord(int id) {
		studentRepository.deleteById(id);
	}

	public List<StudentData> displayAll() {
		List<StudentData> studentList = (List<StudentData>) studentRepository.findAll();
		return studentList;
	}
}
