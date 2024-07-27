package com.spring.security__jwt.payLoad;


//Class AuthRequest purpose of this class is DTO for carrying user login credentials
// from client to server
public class AuthRequest {
	
	//this classused to capture the username and password from the
	//client's HTTP request body during the authentication process. 
	
	//required fields
	private String username;
    private String password;
    
    //Getter and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    

}
