package com.example.AdharService.response;

public class AdharResponse {
	private int employee_id;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	private String adhar_Number;
	private String city;
	private String state;
	public String getAdhar_Number() {
		return adhar_Number;
	}
	public void setAdhar_Number(String adhar_Number) {
		this.adhar_Number = adhar_Number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
