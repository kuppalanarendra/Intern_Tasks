package com.spring.security__jwt.payLoad;

//Authresponse class 
public class AuthResponse {
	// field jwt stores JWT
	// after successful authentication it will send to client
	private String jwt;

	// constructor
	public AuthResponse(String jwt) {
		this.jwt = jwt;
	}

	// getter
	// return the value of Jwt
	public String getJwt() {
		return jwt;
	}

}
