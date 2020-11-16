package com.sunsoft.repository;

import org.springframework.data.repository.CrudRepository;

import com.sunsoft.model.StudentData; 

public interface StudentRepository extends CrudRepository<StudentData, Integer> {

}