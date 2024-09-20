package com.example.EmployeeService.DTO;

public class AdharDto {
	private int employee_id;
	private String adhar_Number;
	private String city;
	private String state;
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
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
	@Override
	public String toString() {
		return "AdharDto [employee_id=" + employee_id + ", adhar_Number=" + adhar_Number + ", city=" + city + ", state="
				+ state + "]";
	}

	
	
}
