package com.feign_client.user_service.dto;

public class UserDto {
	private int id;
	private String firstName;
	private String lastaName;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", firstName=" + firstName + ", lastName=" + lastaName + ", email=" + email + "]";
	}
	public String getLastaName() {
		return lastaName;
	}
	public void setLastName(String lastaName) {
		this.lastaName = lastaName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
