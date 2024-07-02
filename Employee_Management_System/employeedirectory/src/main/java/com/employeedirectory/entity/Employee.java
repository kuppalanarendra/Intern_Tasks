package com.employeedirectory.entity;

import java.time.LocalDate;


import org.springframework.cglib.core.Local;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Entity
@Table(name="Employee")
//Employee class is our entity class
public class Employee {
	
	//fields required for Employee
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	@NotEmpty(message="Name Should not empty")
	@NotNull
	private String name;
	
	@NotEmpty(message = "Position should not be empty")
	@NotNull
	private String position;
	
	@NotEmpty(message = "Department should not be empty")
	@NotNull
	private String department;
	
	@Positive(message="Salary must be a positive number")
	@NotNull
	private double salary;
	
	@NotNull
	 private LocalDate joiningDate;
	 
	@Email(message="Email should be in a valid format")
	@NotNull
	 private String email;
	
	@PositiveOrZero(message="Experiemce must be zero or postive number")
	private int experience;
	
	private int performanceScore;
	
	
	//Getter and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(int performanceScore) {
		this.performanceScore = performanceScore;
	}
	
	

}
