package com.example.EmployeeService.DTO;

public class EmployeeResponse {

	private EmployeeDto employee;
	private AdharDto adharDetails;

	public EmployeeDto getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeDto employee) {
		this.employee = employee;
	}

	public AdharDto getAdharDetails() {
		return adharDetails;
	}

	public void setAdharDetails(AdharDto adharDetails) {
		this.adharDetails = adharDetails;
	}

	@Override
	public String toString() {
		return "EmployeeResponse [employee=" + employee + ", adharDetails=" + adharDetails + "]";
	}

}
