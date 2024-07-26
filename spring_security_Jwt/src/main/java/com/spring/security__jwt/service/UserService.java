package com.spring.security__jwt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.security__jwt.entity.User;

public interface UserService extends UserDetailsService {

	User findByUsername(String username);

	User saveUser(User user);

}
