package com.Jdbc;

import java.util.Objects;

public class Student {
  //Argumentso or Variables
	private long id;
	private String name;
	private int age;
	private String grade;
	private String address;

	//No Arg Constructor
	public Student() {

	}

	// Parameterized Constructor for student class
	public Student(long id, String name, int age, String grade, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.address = address;
	}

	// Getters and Setters
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

	// To String method for student class
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", address=" + address
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, grade, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(grade, other.grade)
				&& id == other.id && Objects.equals(name, other.name);
	}

}
