 package com.feign_client.department_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feign_client.department_service.entity.Department;
import com.feign_client.department_service.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepo;

	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepo.save(department);
		
		
	}

	@Override
	public Department getDeapartmentDetailsById(int id) {
		
		return departmentRepo.findById(id).get();
	}

}
