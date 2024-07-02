package com.validate.validations_Exceptionss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validate.validations_Exceptionss.entity.User;
import com.validate.validations_Exceptionss.exceptions.UserAlreadyExists;
import com.validate.validations_Exceptionss.exceptions.UserNotFoundException;
import com.validate.validations_Exceptionss.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class UserController { //controler class used to Handle request and responses of user
	
	@Autowired
	private UserService userService; 
	
	
	@PostMapping("/user") //Postmaping to post the data into database
	public User create(@RequestBody @Valid User user) throws UserAlreadyExists   {	
		
		
		return userService.insert(user);
		
	}
	
	//Get mapping to get the data based on Id
	@GetMapping("/get/{id}")
	public User retrive(@PathVariable(value = "id") long id) throws UserNotFoundException {
		System.out.println(id);
		return	userService.getById(id);	
		
	}
	
	
	@GetMapping("/getAll")
	public List<User> fetchAll(){ //Retrieve all the users data  
		
		return userService.getAllUsers();
		
	}
	
	//putmapping to update the data based on id
	@PutMapping("/update/{id}")
	public User update(@PathVariable(value="id") long id,@RequestBody User user) throws UserNotFoundException {
		
		
		return userService.updateById(id,user);
		
	}
	
	//Delete mapping to delete the data based on id
	@DeleteMapping("/delete/{id}")
	public String remove(@PathVariable(value="id") long id) throws UserNotFoundException {
		return userService.deleteById(id);
	}

}
