package com.example.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banking_app.entity.AddressDetails;

@Repository
public interface AddresRepository extends JpaRepository<AddressDetails, Long> {
	
    AddressDetails findById(long id);
}
