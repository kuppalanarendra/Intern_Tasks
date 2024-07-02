package com.Jdbc;

import java.util.Scanner;

//StudentApp is the main class
public class StudentApp {

	// Scanner class to take the user input through console
	private static Scanner sc = new Scanner(System.in);
	// creation of object to StudentDaoImpl class and give refernce to StudentDao
	// Interface
	// In this case we are achieve Abstraction by giving child object to parent
	// refernce
	static StudentDao studentDao = new StudentDaoImpl();
	// creation of object to StudentService class abd intialize StudentDao field
	static StudentService studentService = new StudentService(studentDao);

	// main method
	public static void main(String[] args) {

		StudentApp studentApp = new StudentApp();

		while (true) {
			System.out.println("Choose menu");
			System.out.println("1.Add new Student");
			System.out.println("2. View All students");
			System.out.println("3. View Student By Id");
			System.out.println("4.Update Student");
			System.out.println("5. Delete Student By Id\n");
			System.out.println("Choose your choice");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				viewAllStudents();
				break;
			case 3:
				viewStudentById();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				
				return;
			default:
				System.out.println("Default");
				break;

			}
		}

	}

	private static void addStudent() {
		System.err.println("Enter Students Dteails");
		System.out.println("Enter Id:");
		long id = sc.nextLong();
		sc.nextLine();
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter age:");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Grade");
		String grade = sc.nextLine();
		System.out.println("Enter Address");
		String address = sc.nextLine();
		Student student = new Student(id, name, age, grade, address);
		studentService.addStudent(student);

	}

	private static void  viewAllStudents() {
		studentService.getAllStudents();
	}

	private static void viewStudentById() {
		System.out.println("Enter Id to view the Student Details");
		long id = sc.nextLong();
		studentService.getStudentById(id);
	}

	private static void updateStudent() {
		System.out.println("Enter Student Id");
		long id = sc.nextLong();
		sc.nextLine();
		Student student = studentService.getStudentById(id);
		if (student != null) {
			System.out.println("Enter the details to Update the Student");
			System.out.println("Enter name:");
			String name = sc.nextLine();

			System.out.println("Enter age:");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Grade");
			String grade = sc.nextLine();
			System.out.println("Enter Address");
			String address = sc.nextLine();
			student.setName(name);
			student.setAge(age);
			student.setGrade(grade);
			student.setAddress(address);
			studentService.updateStudent(student);
		} else {
			System.out.println("Student not found with given id");
		}
	}

	private static void deleteStudent() {
		System.out.println("Delete Student by Id");
		System.out.println("Enter Student Id;");
		long id = sc.nextLong();
		studentService.deleteStudent(id);
	}

}
