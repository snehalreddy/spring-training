package com.sunsoft.repository;

import org.springframework.data.repository.CrudRepository;

import com.sunsoft.model.User; 

public interface UserRepository extends CrudRepository<User, Integer> {

}