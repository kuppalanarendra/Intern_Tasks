package com.validate.validations_Exceptionss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validate.validations_Exceptionss.entity.User;
import com.validate.validations_Exceptionss.exceptions.UserAlreadyExists;
import com.validate.validations_Exceptionss.exceptions.UserNotFoundException;
import com.validate.validations_Exceptionss.repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService { //Service class used to perform business logic 

	@Autowired
	private UserRepository userRepo;
//Insert the data into database by validating the User entity fields
	public User insert(@Valid User user) throws UserAlreadyExists {
	   String email= user.getEmail();
	   if(userRepo.findByEmail(email)!=null) {
		   throw new UserAlreadyExists("An Account has been already registered  with this email id:  " + email);
	   }
	   else {
		   return userRepo.save(user);
	   }
		

	}
 //Retrieve the data based on id
	public User getById(long id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);

		System.out.println("userId");
		System.out.println(user.isPresent());
		User u = new User();
		if (user.isPresent() == false) {
			throw new UserNotFoundException("User Not found with given id " + id);

		} else {
			return u = user.get();
		}

	}

	
	//update the data based on id
	public User updateById(long id, User user) throws UserNotFoundException {
		Optional<User> user1 = userRepo.findById(id);
		if (user1.isPresent() == false) {
			throw new UserNotFoundException("User Not found with given id to update the data" + id);

		} else {
			User u= user1.get();
			u.setName(user.getName());
			u.setAge(user.getAge());
			u.setGender(user.getGender());
			u.setNationality(user.getNationality());
			
			return userRepo.save(u);
		}

		
		
		
	}

	//Delete the data based on id
	public String deleteById(long id) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(id);
		if (user.isPresent() == false) {
			throw new UserNotFoundException("User Not found with given id " + id);

		} else {
			userRepo.deleteById(id);
			return "An Account has been deleted successfully";
		}

		
		
		
	}
	
	//Retrive all the data 
	public List<User> getAllUsers() {
	List<User> lst=	userRepo.findAll();
	return lst;
		
	}

}
