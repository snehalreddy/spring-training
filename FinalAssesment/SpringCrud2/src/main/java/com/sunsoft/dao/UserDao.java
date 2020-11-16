package com.sunsoft.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunsoft.model.User;
import com.sunsoft.repository.UserRepository;

@Service
public class UserDao {
	@Autowired
	UserRepository userRepo;

	public void insertData(User userObj) {
		userRepo.save(userObj);
	}

	public void deleteRecord(int id) {
		userRepo.deleteById(id);
	}
	
	public boolean SearchRecord(String name, String password) {
		List<User> userList = (List<User>) userRepo.findAll();
		for(User u : userList)
		{
			if(u.getName().contentEquals(name) &&u.getPassword().contentEquals(password))
			{
				return true;
			}
		}
		return false;
			
	}

	public List<User> displayAll() {
		List<User> userList = (List<User>) userRepo.findAll();
		return userList;
	}
}
