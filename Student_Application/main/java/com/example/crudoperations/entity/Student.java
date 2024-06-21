package com.example.crudoperations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Student Entity Class
@Entity //@Entity annotation marks this class as a JPA entity,it means it will be mapped to a database table
@Table(name="Students") //specify the name of the database table to which this entity class (Student) is mapped
public class Student {
	
	@Id //@Id:- Marks this id field as the primary key of the entity.
	@GeneratedValue(strategy = GenerationType.IDENTITY)//way of incrementing the id automatically
	private long id; 
	
	
	private String name;
	private int age;
	private String grade;
	private String address;
	
	//Getetrs and Setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
