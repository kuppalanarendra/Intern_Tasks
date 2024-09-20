package com.feign_client.department_service.service;

import org.springframework.stereotype.Service;

import com.feign_client.department_service.entity.Department;


public interface DepartmentService {

	Department saveDepartment(Department department);

	Department getDeapartmentDetailsById(int id);

}
