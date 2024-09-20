package com.feign_client.user_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feign_client.user_service.dto.ResponseDto;
import com.feign_client.user_service.entity.User;
import com.feign_client.user_service.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser= userService.saveUser(user);
		return new ResponseEntity<>(savedUser,HttpStatus.CREATED);
		
		
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<ResponseDto> getUserDetailsById(@PathVariable("id") int id){
	ResponseDto responseDto=	userService.getUserDatailsById(id);
		return ResponseEntity.ok(responseDto);
		
	}
	
	

}
