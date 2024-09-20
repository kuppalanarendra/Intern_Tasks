package com.example.AdharService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AdharService.entity.Adhar;

@Repository
public interface AdharRepository extends JpaRepository<Adhar, Integer> {
	Adhar findById(int id);
	

}
