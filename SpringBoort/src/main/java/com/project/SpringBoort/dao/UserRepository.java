package com.project.SpringBoort.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.SpringBoort.entities.User;

public interface UserRepository  extends CrudRepository<User, Integer>{
	
		

}
