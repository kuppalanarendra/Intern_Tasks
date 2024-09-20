package com.example.EmployeeService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeService.DTO.EmployeeResponse;
import com.example.EmployeeService.entity.EmployeeData;
import com.example.EmployeeService.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee/{id}")
	public EmployeeResponse getEmployee(@PathVariable(value = "id") int id) {

		return employeeService.getEmplyeeById(id);

	}
     
	@PostMapping("/employee/create")
	public EmployeeResponse createEmployee(@RequestBody @Validated EmployeeData employeeData) {
       System.out.println(employeeData.getEmployee());
		return employeeService.create(employeeData);

	}
	
	@PutMapping("/employee/update/{id}")
	public EmployeeResponse updateEmployee(@PathVariable ("id") int id, @RequestBody EmployeeData employeeData) {
		
		
		return employeeService.updateEmployeeById(id,employeeData);
		
	}
	
	@DeleteMapping("/employee/delete/{id}")
	public void deleteEmployee(@PathVariable("id") int id) {
		employeeService.deleteEmployeeById(id);
	}

}
