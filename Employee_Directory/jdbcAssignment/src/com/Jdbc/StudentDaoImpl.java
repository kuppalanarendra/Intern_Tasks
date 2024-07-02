package com.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//implements StudentDao Interface using implements Keyword
//Here this class implements all unimplemented methods which are present in StudentDao Infc
public class StudentDaoImpl implements StudentDao {

	// Connection method to establish connection from Java to database
	// Here we have to follow 4 steps shown below..
	
	private static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		// Step 1: Loading the driver class
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Step 2:Creation of Connection object
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "Narendra");
		return con;
	}
   
	//addStudent Method Implementation
	@Override
	public void addStudent(Student student) {
		try {
			Connection con = getDBConnection();
			String sql = "INSERT INTO Students values(?,?,?,?,?) ";
			// Step 3: creation of Statement Object
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setLong(1, student.getId());
			psmt.setString(2, student.getName());
			psmt.setInt(3, student.getAge());
			psmt.setString(4, student.getGrade());
			psmt.setString(5, student.getAddress());

			// Step 4: Executing the query
			int i = psmt.executeUpdate();
			if (i > 0) {
				System.out.println("Student Data Added Successfully");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    //List Of All Students 
	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		
		try {
			Connection con = getDBConnection();
			String sql = "SELECT * FROM Students";
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getLong(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setGrade(rs.getString(4));
				student.setAddress(rs.getString(5));
				students.add(student);

			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(students);
		for (Student studnt : students) {
			System.out.println(studnt);

		}
		return students;
	}

	
	//Get The Student details based on id
	@Override
	public Student getStudentById(long id) {
		Student student = new Student();
		try {
			Connection con = getDBConnection();
			String sql = "SELECT * FROM Students WHERE id=?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setLong(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				student.setId(rs.getLong(1));
				student.setName(rs.getString(2));
				student.setAge(rs.getInt(3));
				student.setGrade(rs.getString(4));
				student.setAddress(rs.getString(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(student);
		return student;

	}

	
	//Updatet the Student details
	@Override
	public void updateStudent(Student student) {
		try {
			Connection con = getDBConnection();
			String sql = "UPDATE Students SET name=?, age=?, grade=?,address=? WHERE id=?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, student.getName());
			psmt.setInt(2, student.getAge());
			psmt.setString(3, student.getGrade());
			psmt.setString(4, student.getAddress());
			psmt.setLong(5, student.getId());
			int i = psmt.executeUpdate();
			if (i > 0) {
				System.err.println("Data Updated Successfully");
				System.out.println(student);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//Delete the Student based on id
	@Override
	public void deleteStudent(long id) {
		
		try {
			Connection con = getDBConnection();
			String sql = "DELETE FROM Students where id=?";
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setLong(1, id);
			
			int i = psmt.executeUpdate();
		
			if (i > 0) {
				
				System.out.println("Data Deleted Successfully");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
