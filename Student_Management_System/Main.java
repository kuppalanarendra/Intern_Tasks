package com.pack1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

//Main Class
public class Main { 
	private static StudentManager stdManager = new StudentManager();
	//Scanner class to take user input through console
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		System.out.println("Choose your Menu:");
		System.out.println("1. Add a new student");
		System.out.println("2. Remove existing student");
		System.out.println("3. update existing student");
		System.out.println("4. Enter the id to search Student");
		System.out.println("5. Display all Students");
		System.out.println("6. save to file");
		System.out.println("7. Load the File");
		

		while (true) {
			System.err.println("Enter your choice");
			
			int choice = sc.nextInt();
			switch (choice) { //switch is conditional statement based on given switch expression
			                  // it will exceute matching conditional case label block
			case 1:
				addStudent();
				break;
			case 2:
				removeStudent();
				break;

			case 3:
				updateStudent();
				break;
				
			case 4:
				searchStudent();
				break;
			case 5:
				stdManager.displayAllStudents();
				break;
			case 6:
				stdManager.creationFile(); //caling of file creation method
				stdManager.saveToFile();
				
				break;
			case 7:
				stdManager.loadFromFile();
				
				return;
			default:{
				System.out.println("Invalid choice ");
			}

			}
		}

	}
    
	
	private static void addStudent() {
		System.err.println("Enter Studendt Details to add student");
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.print("Enter grade: ");
		String grade = sc.nextLine();
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		stdManager.addStudent(new Student(id, name, age, grade, address));

	}

	
   
	private static void updateStudent() {
		System.err.println("Update the student Details based on Id");
		System.out.print("Enter ID: ");
		int id = sc.nextInt();
		if(stdManager.check(id)) {
		sc.nextLine(); // Consume newline
		System.out.print("Enter name: ");
		String name = sc.nextLine();
		System.out.print("Enter age: ");
		int age = sc.nextInt();
		sc.nextLine(); // Consume newline
		System.out.print("Enter grade: ");
		String grade = sc.nextLine();
		System.out.print("Enter address: ");
		String address = sc.nextLine();
		stdManager.updateStudent(new Student(id, name, age, grade, address));

	}
		else {
			System.out.println("Student not found with given Id\nIf you want to create or add new student with given Id");
			System.out.println("Yes/No");
			String str=sc.next();
			if(str.equalsIgnoreCase("Yes")) {
				addStudent();
				
			}
			
		}
	}
	private static   void searchStudent() {
		System.err.println("Search The Student based on id");
		System.out.println("Enter student id to search");
		int id= sc.nextInt();
		stdManager.searchStudent(id);
	}
	
	private static void removeStudent() {
		System.err.println("Enter Id to remove Student");
		int id = sc.nextInt();
		stdManager.removeStudent(id);
	}
}
