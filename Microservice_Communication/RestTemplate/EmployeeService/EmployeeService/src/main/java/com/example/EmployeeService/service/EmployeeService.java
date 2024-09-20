package com.example.EmployeeService.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.AdharService.entity.Adhar;
import com.example.EmployeeService.DTO.AdharDto;
import com.example.EmployeeService.DTO.EmployeeDto;
import com.example.EmployeeService.DTO.EmployeeResponse;
import com.example.EmployeeService.entity.Employee;
import com.example.EmployeeService.entity.EmployeeData;
import com.example.EmployeeService.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ModelMapper modelMapper;

	@Value("${app.base.url}")
	private String appBaseUrl;

	public EmployeeResponse getEmplyeeById(int id) {
		Employee emply = empRepo.findById(id);
		EmployeeDto employeeDto = modelMapper.map(emply, EmployeeDto.class);
		AdharDto adharDto = restTemplate.getForObject(appBaseUrl + "/{id}", AdharDto.class, id);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmployee(employeeDto);
		employeeResponse.setAdharDetails(adharDto);
		return employeeResponse;

	}

	public EmployeeResponse create(EmployeeData employeeData) {
		Employee employee = employeeData.getEmployee();
		EmployeeDto employeeDto = modelMapper.map(empRepo.save(employee), EmployeeDto.class);
		Adhar adhar = employeeData.getAdhar();
		System.out.println(adhar);
		adhar.setEmployee_id(employee.getId());
		System.out.println(adhar.getEmployee_id());
		System.out.println(adhar);
		AdharDto adharDto = restTemplate.postForObject(appBaseUrl + "/create", adhar, AdharDto.class);
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setEmployee(employeeDto);
		employeeResponse.setAdharDetails(adharDto);
		return employeeResponse;
	}

	public EmployeeResponse updateEmployeeById(int id, EmployeeData employeeData) {
		Employee employee = employeeData.getEmployee();
		Employee emply = empRepo.findById(id);
		emply.setName(employee.getName());
		emply.setPosition(employee.getPosition());
		emply.setSalary(employee.getSalary());
		EmployeeDto employeeDto = modelMapper.map(empRepo.save(emply), EmployeeDto.class);
		System.out.println(employeeDto.getName());
		Adhar adhar = employeeData.getAdhar();
		System.out.println(adhar);
		restTemplate.put(appBaseUrl + "/update/{id}", adhar, id);
		AdharDto adharDto = restTemplate.getForObject(appBaseUrl + "/{id}", AdharDto.class, id);
		System.out.println(adharDto.getEmployee_id());
		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setAdharDetails(adharDto);
		employeeResponse.setEmployee(employeeDto);
		return employeeResponse;

	}

	public void deleteEmployeeById(int id) {
		empRepo.deleteById(id);
		restTemplate.delete(appBaseUrl+"/delete/{id}", id);
		
	}

}
