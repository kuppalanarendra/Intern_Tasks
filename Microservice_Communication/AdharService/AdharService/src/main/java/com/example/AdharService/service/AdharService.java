package com.example.AdharService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AdharService.entity.Adhar;
import com.example.AdharService.repository.AdharRepository;

@Service
public class AdharService {
	
	@Autowired
	private AdharRepository adharRepo;
	
	public Adhar getDetailsById(int id) {
	return	adharRepo.findById(id);
	}

	public Adhar create(Adhar adhar) {
	return	adharRepo.save(adhar);
		
	}

	public Adhar updateDetailsById(int id, Adhar adhar) {
	Adhar addhar=	adharRepo.findById(id);
	addhar.setAdhar_Number(adhar.getAdhar_Number());
	addhar.setCity(adhar.getCity());
	addhar.setState(adhar.getState());
	return adharRepo.save(addhar);
	}

	public void deleteById(int id) {
		adharRepo.deleteById(id);
		
	}
	 

}
