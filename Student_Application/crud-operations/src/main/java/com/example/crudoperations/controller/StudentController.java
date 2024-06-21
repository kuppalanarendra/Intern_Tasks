package com.example.crudoperations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudoperations.entity.Student;
import com.example.crudoperations.exceptions.StudentNotFoundException;
import com.example.crudoperations.service.StudentService;

@RestController // @RestController: Marks the class as a controller that handles incoming HTTP
				// requests and sends HTTP responses back.
@RequestMapping("/Students")
public class StudentController {

	@Autowired // @Autowired annotation is used for automatic dependency injection
	private StudentService studentService;

	@PostMapping("/") // @PostMapping annotation in Spring Boot is used to handle HTTP POST requests
						// to create/insert new Records
	public Student addStudent(@RequestBody Student student) {
		// calling of addStudent in StudentService class using studentService bean
		return studentService.addStudent(student);

	}

	@GetMapping("/") // @GetMapping annotation in Spring Boot is used to handle HTTP GET requests.
						// i,e retrieve the data
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();

	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable(value = "id") long id) throws StudentNotFoundException {
		return studentService.getStudentByID(id);

	}

	// upadte the data based on id
	@PutMapping("/{id}") // @PutMapping annotation in Spring Boot is used to handle HTTP PUT requests.
							// This is typically used for updating existing records.
	public Student updateStudent(@PathVariable(value = "id") long id, @RequestBody Student student)
			throws StudentNotFoundException {
		return studentService.updateStudent(id, student);

	}

	// delete the data based on id
	@DeleteMapping("/{id}") // @DeleteMapping annotation in Spring Boot is used to handle HTTP DELETE
							// requests. This is typically used for deleting existing records
	public String deleteStudent(@PathVariable(value = "id") long id) throws StudentNotFoundException {
		return studentService.deleteStudentById(id);

	}

}
