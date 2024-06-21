package com.example.crudoperations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudoperations.entity.Student;
import com.example.crudoperations.exceptions.StudentNotFoundException;
import com.example.crudoperations.repository.StudentRepository;

@Service //To mark this class as a service component and help to helpful to perform business logic with repository
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	//addStudent() method to add student to database
	public Student addStudent(Student student) {
		return studentRepository.save(student);
		 
		
		
	}
	//Retrieve all the students present in database
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
		
	}
	//Retrieve the Student based on Id
	public Student getStudentByID(long id) throws StudentNotFoundException {
			
	  Optional<Student> student=	studentRepository.findById(id);
	  Student student1 = new Student();
	   if(student.isPresent()==false) { //if student is not then it throw custom exception
		   
		   throw new StudentNotFoundException("Student not found with given Id");
	   }
	   else {
		   return student1=student.get();
	   }
	   
	
		
	}
	
	//updatesStudent() method to upadte the student based on id
	public Student updateStudent(long id, Student student) throws StudentNotFoundException {
		Optional<Student> student1=	studentRepository.findById(id);
		if(student1.isPresent()==false) { //if student is not then it throw custom exception
			   
			   throw new StudentNotFoundException("Student not found with given Id to update the data");
		   }
		   else {
			  Student std= new Student();
			  std=student1.get();
			  std.setName(student.getName());
			  std.setAge(student.getAge());
			  std.setGrade(student.getGrade());
			  std.setAddress(student.getAddress());
			  return studentRepository.save(std);
		   }
		   
		
	}
	//deleteStudent() to delete  the student based on id
	public String deleteStudentById(long id) throws StudentNotFoundException {
		Optional<Student> student=studentRepository.findById(id);
		if(student.isPresent()==false) {
			throw new StudentNotFoundException("Student not found with given id to delete data");
		}else {
			studentRepository.deleteById(id);
			return "Student data deleted Successfully";
		}
		
		
	}

}
