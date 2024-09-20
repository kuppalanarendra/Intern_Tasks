package com.example.EmployeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeService.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
   Employee findById(int id);
}
