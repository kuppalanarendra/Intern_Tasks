package com.spring.security__jwt.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.security__jwt.entity.User;
import com.spring.security__jwt.repository.UserRepository;

@Service
public class UserServiceImpls implements UserService {

	@Autowired
	// Injects the UserRepository for database operations related to User entities.

	private UserRepository userRepository;

	@Autowired
	// Injects the PasswordEncoder for encoding passwords before saving them to the
	// database.
	private PasswordEncoder passwordEncoder;

	@Override
	// This method uses the UserRepository to find and return
	// a User entity by its username.
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	// saveUser method save the User registration details
	public User saveUser(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return userRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("load called");
		System.out.println(username);
		User user = userRepository.findByUsername(username);

		if (user == null) {
			System.out.println("Exception called");
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList());
	}
}
