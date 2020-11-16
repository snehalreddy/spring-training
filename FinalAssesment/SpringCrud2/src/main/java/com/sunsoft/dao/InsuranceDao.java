package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.InsuranceData;
import com.sunsoft.repository.InsuranceRepository;
import com.sunsoft.repository.StudentRepository;

@Service
public class InsuranceDao {
	@Autowired
	InsuranceRepository insuranceRepo;

	public void insertData(InsuranceData studentObj) {
		insuranceRepo.save(studentObj);
	}

	public void deleteRecord(int id) {
		insuranceRepo.deleteById(id);
	}

	public List<InsuranceData> displayAll() {
		List<InsuranceData> studentList = (List<InsuranceData>) insuranceRepo.findAll();
		return studentList;
	}
}
