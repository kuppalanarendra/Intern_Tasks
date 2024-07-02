package com.pack1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

//Student Manager Class
public class StudentManager {
	// List Interface implemented class ArrayList to store list of Student Details
	private ArrayList<Student> students = new ArrayList<>();

	// Map Interface implemented class HashMap to store key value pair of data
	private HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();

	// TreeSet to store the details of students in sorting order of their id
	private TreeSet<Student> sortedStudents = new TreeSet<>();

	// add method to add student details
	public void addStudent(Student student) {
		if (studentMap.containsKey(student.getId())) { // contains method check if student already present
														// or not with given id
			System.out.println("Student Already Exists");
		} else {
			// if not present adding the student details
			students.add(student);
			studentMap.put(student.getId(), student);
			sortedStudents.add(student);
		}
		System.err.println("Students Details:" );
		for(Student studnt:students) {
			System.out.println(studnt);
		}

	}

	// remove method to remove the student based on id
	public void removeStudent(int id) {
		Student student = studentMap.get(id);
		if (student != null) {
			students.remove(student);
			studentMap.remove(id);
			sortedStudents.remove(student);
			System.out.println("Student data removed Successfully");
		} else {
			System.out.println("Student not present with given Id");
		}

	}
	
	//check if student present or not based on id
	public boolean check(int id) {
		boolean status=false;
	Student std=	studentMap.get(id);
	if(std!=null) {
		status=true;
	}
	return status;
	}

	// update the existing student
	public void updateStudent(Student student) {
		Student student1 = studentMap.get(student.getId());
		if (student1 != null) {
			sortedStudents.remove(student1);
			student1.setId(student.getId());
			student1.setName(student.getName());
			student1.setAge(student.getAge());
			student1.setGrade(student.getGrade());
			student1.setAddress(student.getAddress());
			studentMap.put(student.getId(), student1);
			sortedStudents.add(student1);
			System.out.println(sortedStudents);
		} else {
			System.out.println("Student not found with given Id");
		}
	}

	// search method to search the student based on id
	public void searchStudent(int id) {
		Student student = studentMap.get(id);
		System.out.println(student);
	}

	// display all the students
	public void displayAllStudents() {
		System.err.println("Display all students");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	// Creattion of File Class to refer the file name
	private File f = new File("D:\\narendra\\StudentData.txt");

	public void creationFile() {
		try {
			f.createNewFile();
			System.err.println("File Created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method to load the file which is present in our loacal directory
	public void loadFromFile() throws IOException {

		if (f.exists()) { //exists method to check file is exists or not
			
			try {
				FileReader fr = new FileReader(f); // FileReader is a class to read data from file
				BufferedReader br = new BufferedReader(fr);// BufferedReader class to read file
				String line;

				boolean isHeader = true;

				while ((line = br.readLine()) != null) { // readLine method to read a line from file
					if (isHeader) {
						isHeader = false;

						continue;// Skip the header line

					}

					String[] values = line.split(" ");

					int id = Integer.parseInt(values[0]);
					String name = values[1];
					
					int age = Integer.parseInt(values[2]);
					String grade = values[3];
					String address = values[4];

					Student student = new Student(id, name, age, grade, address);
					List<Student> l = new ArrayList<>();
					l.add(student);
					System.out.println("Reading the data from file ");
					for (Student std : l) {
						System.out.println(std);
					}

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("File Not found ");
		}

	}

	// save the data to file
	public void saveToFile() {
		if (f.exists()) {
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, true))) {
				if (f.length() == 0) {
					bw.write("Id Name Age Grade Address ");
					bw.newLine();
				}
				for (Student student : students) {
					bw.write(student.getId() + " " + student.getName() + " " + student.getAge() + " "
							+ student.getGrade() + " " + student.getAddress());
					bw.newLine();
				}
				System.out.println("Data Saved to file");


			} catch (IOException e) {
				System.out.println("An error occurred while saving to file.");
				e.printStackTrace();
			}
		}
	}

}
