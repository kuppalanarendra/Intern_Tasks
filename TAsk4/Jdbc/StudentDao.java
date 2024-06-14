package com.Jdbc;

import java.util.List;

//Inteface StudentDAO 
public interface StudentDao {

	// StudentDao Inteface contains method to perform CRUD operations
	// Metghods present inside StudentDaom interface are Abstract methods
	// only method declaration i,e UnImplemented Methods

	// 1) addStudent Method
	void addStudent(Student student);

	// 2) Getting List of All students from Database
	List<Student> getAllStudents();

	// 3)Getting the student based on Id
	Student getStudentById(long id);

	// 4) Update the student
	void updateStudent(Student student);

	// 5)Delete the student based on Id
	void deleteStudent(long id);

}
