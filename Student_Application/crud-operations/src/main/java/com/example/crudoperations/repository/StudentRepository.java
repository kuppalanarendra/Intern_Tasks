package com.example.crudoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudoperations.entity.Student;



//@Repository Annotation: Marks the interface StudentRepository as a Spring Data repository.
//It indicates to Spring that this interface is responsible for database operations related to the Student entity.

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	// This interface inherits CRUD methods from JpaRepository

	
}
