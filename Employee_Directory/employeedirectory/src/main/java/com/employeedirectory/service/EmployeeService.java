package com.employeedirectory.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeedirectory.advice.Duplicate;
import com.employeedirectory.advice.EmployeeReport;
import com.employeedirectory.entity.Employee;
import com.employeedirectory.exceptions.ResourceNotFoundException;
import com.employeedirectory.repository.EmployeeRepository;

import jakarta.validation.Valid;

@Service
public class EmployeeService { //EmployeeService class

	@Autowired
	private EmployeeRepository employeeRepository;

	
	//adding of Employee data
	public Employee addEmployee(@Valid Employee employee) {

		LocalDate joiningDate = employee.getJoiningDate();
	//setting experience to employee by passing joiniing date to empExperince() method
		employee.setExperience(empExperience(joiningDate));
		return employeeRepository.save(employee);

	}
   //method to find employee experience from joining date to current date
	private int empExperience(LocalDate joiningDate) {

		LocalDate currentDate = LocalDate.now();

		return Period.between(joiningDate, currentDate).getYears();

	}
     
	//update of employee based on id 
	public Employee updateEmployee(long id, Employee employee) throws ResourceNotFoundException {
		Employee emply = employeeRepository.findById(id);
		if (emply == null) { 
			//based on if employee not found then it throws Exception
			throw new ResourceNotFoundException("Employee Not found with given Id");

		} else {
			emply.setName(employee.getName());
			emply.setEmail(employee.getEmail());
			emply.setDepartment(employee.getDepartment());
			emply.setJoiningDate(employee.getJoiningDate());
			emply.setPerformanceScore(employee.getPerformanceScore());
			emply.setPosition(employee.getPosition());
			emply.setSalary(employee.getSalary());

		}
		return employeeRepository.save(emply);

	}
    
	//finding of total salary by department
	public double totalSalaryByDeaprtemnt(String department) {
		List<Employee> listEmployee = employeeRepository.findByDepartment(department);
		double totalSalary = 0;
		for (Employee employee : listEmployee) {
			totalSalary += employee.getSalary();
		}
		return totalSalary;
	}
  
	//finding of employee between to given dates
	public List<Employee> joiningDateRange(LocalDate startDate, LocalDate endDate) {

		return employeeRepository.findByJoiningDateBetween(startDate, endDate);
	}
	
   //update the employee position based on id if  experience is greater than 5 years
	public Employee updateEmployeePosition(long id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id);
		if(employee==null) {
			throw new ResourceNotFoundException("Employee not found with given id to update Employee position");
		}
		else {
			System.out.println(employee.getExperience());
			int experience = employee.getExperience();
			if (experience > 3) {
				employee.setPosition("Senior");
			}

			return employeeRepository.save(employee);
		}

		

	}
  
	
	//Getting of EmployeeReport based on id
	public EmployeeReport getEmployeeReport(long id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id);
		EmployeeReport employeeReport = new EmployeeReport();
		if (employee== null) {
             throw new ResourceNotFoundException("Employee not found with given id");
		}
		else {
		

			employeeReport.setEmployeeId(employee.getId());
			employeeReport.setEmployeeName(employee.getName());
			employeeReport.setDepartment(employee.getDepartment());
			employeeReport.setPosition(employee.getPosition());
			employeeReport.setEmail(employee.getEmail());
			employeeReport.setSalary(employee.getSalary());
			employeeReport.setExperience(employee.getExperience());

			

		}
		return employeeReport;

	}
    //based on position finding averageSalaryByPosition
	public double averageSalaryByPosition(String position) {
		System.out.println(position);
		return employeeRepository.findAverageSalaryGroupedByPosition(position);
	}
	
   //promotion eligibility check by id based on performance score and experience
	public boolean promotionCheck(long id) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(id);
		if(employee==null) {
			throw new ResourceNotFoundException("Employee not found with given Id to Check Promotion");
		}
		
		return employee.getPerformanceScore() > 80 && employee.getExperience() >= 4;

	}

	public List departmentPerformance() {
	List<Employee> employees=	employeeRepository.findAll();
	List departments= new ArrayList();
	for(Employee employee:employees) {
		
		//each employee performance score is checked with averageperformnce score of all 
		if(employee.getPerformanceScore()>averagePerformanceScore()) {
			departments.add(employee.getDepartment());
			
		}
	}
	return departments;
	}
	//based on given department finding  of budget
	public double budgetAmount(String department) {
		System.out.println("Durga Called");
		List<Employee> employee = employeeRepository.findByDepartment(department);
		double departmentBudget = 0.0;
		System.out.println(departmentBudget);
		System.out.println(employee);
		for (Employee emp : employee) {
			System.out.println(employee.size());
			departmentBudget = departmentBudget + emp.getSalary();
			System.out.println(emp.getSalary());
			System.out.println(departmentBudget);
		}
		return departmentBudget;

	}
   //finding of top highest Employee 
	public List<Employee> topHighestEmployee(int n) {

		return employeeRepository.findTopNhighestEmployess(n);
	}

	
  // finding of duplicate employee 
	public List<Duplicate> duplicateEmployee() {
		List<String> duplicateEmails = employeeRepository.findDuplicates();

		List<Duplicate> list = new ArrayList<>();
		Duplicate duplicate= new Duplicate();
		for (String email : duplicateEmails) {
			List<Employee> duplicateWithEmail = employeeRepository.findByEmail(email);

			if (!duplicateWithEmail.isEmpty()) {
				duplicate.setEmployeeName(duplicateWithEmail.get(0).getName());
				duplicate.setEmail(duplicateWithEmail.get(0).getEmail());
				
			}
			list.add(duplicate);

		}
		return list;

	}
  //deletion of Employee based on Id
	public String deleteEmployee(long id) {
		employeeRepository.deleteById(id);
		return "Employee deleted Successfully";
		
		
	}
	
	public int averagePerformanceScore() {
		return employeeRepository.averagePerformance();
		
	}
     //sending notification to employee regarding updates
	public String sendNotificationMessage(String message) {
		List<Employee> employees=employeeRepository.findAll();
		for(Employee employee:employees) {
			sendMessageByEmail(employee.getEmail(), message);
			
		}
		return "Notification sent successfully ";
	}
	public void sendMessageByEmail(String email,String message) {
		System.out.println("Send notification to "+email);
		System.out.println("Message:"+message);
		
	}

}
