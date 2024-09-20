package com.example.AdharService.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdharService.entity.Adhar;
import com.example.AdharService.response.AdharResponse;
import com.example.AdharService.service.AdharService;

@RestController
public class AdharController {

	@Autowired
	private AdharService adharService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping("/adhar/{employee_Id}")
	public AdharResponse getDetails(@PathVariable(value = "employee_Id") int employee_Id) {
		Adhar adhar = adharService.getDetailsById(employee_Id);

		return modelMapper.map(adhar, AdharResponse.class);

	}

	@PostMapping("/adhar/create")
	public Adhar create(@RequestBody Adhar adhar) {
		System.err.println("Adhar Service called");

		return adharService.create(adhar);

	}

	@PutMapping("/adhar/update/{id}")
	public AdharResponse updateDetails(@PathVariable("id") int id, @RequestBody Adhar adhar) {
       System.out.println("Adhar CValled"+id);
       System.out.println(adhar.getAdhar_Number());
		return modelMapper.map(adharService.updateDetailsById(id, adhar), AdharResponse.class);

	}
	
	@DeleteMapping("/adhar/delete/{id}")
	public void deleteAdhar(@PathVariable("id") int id) {
		System.out.println("delete called");
		adharService.deleteById(id);
	
		
	}

}
