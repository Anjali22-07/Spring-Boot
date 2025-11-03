package com.project.SpringBoort;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.project.SpringBoort.dao.UserRepository;
import com.project.SpringBoort.entities.User;

@SpringBootApplication
@ComponentScan(basePackages = "com.project.SpringBoort.controller")
public class SpringBoortApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringBoortApplication.class, args);
		
		UserRepository userRepository= context.getBean(UserRepository.class);
		User user= new User();
//		user.setName("Anjali");
//		user.setCity("Lucknow");
//		user.setStatus("I am learning Spring Boot");
//		
//		//to save User 
//		 User user1= userRepository.save(user);
//		 System.out.println(user1);
		 
		 //to update user 
		 
		 //to update user - fetch users id 
//		Optional<User> optional =  userRepository.findById(1);   
//		
//		User result = optional.get();
//		//updating value
//		   result.setName("Anjali Singh");
//		userRepository.save(result);
//		System.out.println(result);
//		System.out.println(user1);
		 
		 
		 //to (fetch)get data-- use findById() or findAll
		 
		 //findAll()- returns Iterator containing your data
		 
		 Iterable<User> allUsers= userRepository.findAll();
		  
		 allUsers.forEach(user1->{
		 System.out.println(user1);
		 });
		 
		 //Deleting data from db : Three ways
		 //delete(user) 2. deleteById(Id)  3. deleteAll()- list of iterable and then deletes all
		 
		 userRepository.deleteAll(allUsers);
		 
		 
		 
		 
		 
	}
 
}
