package com.feign_client.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

	  private int id;
	  private String departmentName;
	  private String departMentAddress;
	  private String departmentCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartMentAddress() {
		return departMentAddress;
	}
	public void setDepartMentAddress(String departMentAddress) {
		this.departMentAddress = departMentAddress;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	  
	  
}
