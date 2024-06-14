package com.Jdbc;

import java.util.List;


//StudentService class
public class StudentService {
	
	
    private final StudentDao studentDao;
  //StudentService class StudentDao field to perform CRUD operations
  
    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(long id) {
        return studentDao.getStudentById(id);
    }

    public void updateStudent(Student student) {
    	studentDao.updateStudent(student);
    }

    public void deleteStudent(long id) {
    	studentDao.deleteStudent(id);
    }
}
