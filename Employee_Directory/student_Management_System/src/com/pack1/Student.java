package com.pack1;

import java.util.Objects;

public class Student implements Comparable<Student> {
	//Variable or attributes required for student class
	private int id;
    private String name;
    private int age;
    private String grade;
    private String address;
    
    
    //Constructor
	public Student(int id, String name, int age, String grade, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.address = address;
	}
	
	//Getter and Setters 
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
   
	
	//To String 
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", address=" + address
				+ "]";
	}
    //Hashcode method
	@Override
	public int hashCode() {
		return Objects.hash(address, age, grade, id, name);
	}
  
	
	//equals method
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
	
	//compareTo method in Comparable Interface
	//sort the students based on id
	@Override
	public int compareTo(Student std) {
		
		return Integer.compare(this.id, std.id);
	}

	
	
	
	

}
