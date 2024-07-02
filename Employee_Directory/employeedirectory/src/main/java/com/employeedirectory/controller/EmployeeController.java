package com.employeedirectory.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.employeedirectory.advice.Duplicate;
import com.employeedirectory.advice.EmployeeReport;
import com.employeedirectory.entity.Employee;
import com.employeedirectory.exceptions.ResourceNotFoundException;
import com.employeedirectory.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
//Controller class 
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/")
	//adding of Employee 
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/update/{id}")
	//updating of Employee based on id
	public Employee updateEmployee(@PathVariable(value="id") long id, @RequestBody Employee employee) throws ResourceNotFoundException {
		return employeeService.updateEmployee(id,employee);
		 
		
	}
	@DeleteMapping("/delete/{id}")
	//Delete of Employee based on Id
	public String deleteEmployee(@PathVariable (value="id") long id) {
		employeeService.deleteEmployee(id);
		return null;
		
	}

	@GetMapping("/department/total-salary")
	//totalSalary method find total salary based on department
	public String totoalSalary(@RequestParam String department) {
		double totalSalary= employeeService.totalSalaryByDeaprtemnt(department);
		return "Total salary of all employees in "+ department +" is "+ totalSalary;

	}

	@GetMapping("/joing-date-range")
	//joiningDateRange method to find list of Employee between to startDate and endDate
	public List<Employee> joiningDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {

		return employeeService.joiningDateRange(startDate, endDate);

	}

	@PutMapping("/update/position/{id}")
	//based on id update the employee position 
	public Employee updateEmployeePosition(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		return employeeService.updateEmployeePosition(id);

	}
	

	@GetMapping("/report/{id}")
	//based on id geting of Employee Report
	public EmployeeReport getEmployeeReport(@PathVariable(value = "id") long id) throws ResourceNotFoundException {

		return employeeService.getEmployeeReport(id);

	}

	@GetMapping("/position")
	//based on position finding of averagesalary
	public double averageSalaryByPosition(@RequestParam String position) {
		System.out.println(position);
		return employeeService.averageSalaryByPosition(position);

	}
	
	@GetMapping("/promotion/{id}")
	//promotionEligibilityCheck method to check employee eligible for promotion or not
	public boolean promotionEligibilityCheck(@PathVariable(value="id") long id) throws ResourceNotFoundException {
		return employeeService.promotionCheck(id);
		
	}
	
	@PostMapping("/sendNotification")
	//SendNotifiaction to employees 
	public String  sendNotification(@RequestParam String message) {
		return	employeeService.sendNotificationMessage(message);
		 
		
	}
	
	@GetMapping("/performanceAnalysis")
	//analysis of departments performnnce based on employee performance score
	public List departmentPerformanceAnalysis() {
		return employeeService.departmentPerformance();
	}
	@GetMapping("/department/budget")
	//based on given department  finding budgetAmount of that department
	public double budgetAmount(@RequestParam String department) {
		return	employeeService.budgetAmount(department);
		 
		
	}
	@GetMapping("/topN/{n}")
	//method to find Top N Most employees who earned more salary
	public List<Employee> topNHighestEmployee(@PathVariable  (value="n")int n){
		return employeeService.topHighestEmployee(n);
	}
	@GetMapping("/duplicate")
	//Finding of duplicate Employess based on their email address
	public List<Duplicate> duplicateEmployees(){
		return employeeService.duplicateEmployee();
		 
		
	}
	
	
}
