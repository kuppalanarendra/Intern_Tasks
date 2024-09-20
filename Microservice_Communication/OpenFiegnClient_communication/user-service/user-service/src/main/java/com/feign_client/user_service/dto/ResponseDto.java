package com.feign_client.user_service.dto;

public class ResponseDto {

	private UserDto userDto;
	private DepartmentDto departmentDto;

	public UserDto getUserDto() {
		return userDto;
	}

	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}

	public DepartmentDto getDepartmentDto() {
		return departmentDto;
	}

	public void setDepartmentDto(DepartmentDto departmentDto) {
		this.departmentDto = departmentDto;
	}

}
