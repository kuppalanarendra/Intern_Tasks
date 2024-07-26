package com.spring.security__jwt.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security__jwt.auth.util.JwtUtil;
import com.spring.security__jwt.entity.User;
import com.spring.security__jwt.payLoad.AuthRequest;
import com.spring.security__jwt.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Allows cross-origin requests from frontend
public class UserController { //controller class handles user registration and authentication

    @Autowired
   // Injects the AuthenticationManager for handling authentication.
    private AuthenticationManager authenticationManager; 

    @Autowired
    //injects the JwtUtil for handling JWT operations (like token generation).
    private JwtUtil jwtUtil;

    @Autowired
    //Injects the UserService for user-related operations like register and login users
    private UserService userService;

    @PostMapping("/register")
   //Allows a new user to register by sending a POST request with user details. 
    //The user is then saved to the database using the UserService.
    public User register(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/authenticate")
    //Authenticates a user by verifying their username and password. Upon successful authentication, 
    //and then it generates and returns a JWT token.
    public ResponseEntity<Map<String, String>> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        System.out.println("Authenticate called");
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("Invalid username/password");
        }
        final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        System.err.println(userDetails.getUsername());
        String token = jwtUtil.generateToken(userDetails.getUsername());
        System.out.println(token);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

}
