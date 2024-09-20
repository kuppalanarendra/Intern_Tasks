package com.feign_client.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feign_client.department_service.entity.Department;
import com.feign_client.department_service.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/departments/create")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department){
	Department departmnt=	departmentService.saveDepartment(department);
		
		return new ResponseEntity<Department>(departmnt, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/departments/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") int id){
	Department department=	departmentService.getDeapartmentDetailsById(id);
	return ResponseEntity.ok(department);
	}

}
