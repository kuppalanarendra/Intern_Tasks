package com.jdbcMetaData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MetaData {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Please provide below details to get our required data");
		int portNumber;
		String schemaName;
		String url;
		String userName;
		String password;

		// validate port number
		while (true) {
			System.out.println("Please provide valid port number");
			if (!sc.hasNextInt()) {
				System.out.println("Please enter valid port number");
				// clear inavlid input from the buffer
				sc.next();
				continue;
			} else {
				portNumber = sc.nextInt();
				break;

			}
		}
		
		//validate username
		while(true) {
			System.out.println("Enter username:");
			if(sc.hasNext()) {
				userName=sc.next();
				if(userName.length()>=4) {
					break;
					
				}
				else {
					System.out.println("Invalid userName");
				}
				
			}
			else {
				sc.next();// clear invalid input
			}
			
		}
		//validate password
		while(true) {
			System.out.println("Enter password:");
			if(sc.hasNext()) {
				password=sc.next();
				if(password.length()>=4) {
					break;
					
				}
				else {
					System.out.println("Invalid userName");
				}
				
			}
			else {
				sc.next();// clear invalid input
			}
			
		}
		
		//userinput for schema name
		System.out.println("Enter schema name");
		schemaName= sc.next();
		
		//Establishing JDBC connection
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection=	DriverManager.getConnection("jdbc:mysql://localhost:"+portNumber +"/"+schemaName,userName,password);
       String tableName=sc.next();
       if(isValidTableName(connection,tableName,schemaName)) {
    	   //Sql query
         String sql="SELECT * FROM "+tableName;
         //creation of statement object to transfer sql query fro java to database
       Statement statement=  connection.createStatement();
       	//executing the query and stroring result in resultset
       ResultSet resultset=statement.executeQuery(sql);
       
       //getting the meta data from result set
       ResultSetMetaData resultSetMetaData= resultset.getMetaData();
       int columnCount=resultSetMetaData.getColumnCount();
       System.out.println("Total number of columns in given table is:"+columnCount);
       
       //printing meta data info in console
       for(int i=1; i<=columnCount; i++) {
    	 String columnName=  resultSetMetaData.getColumnName(i);
    	String columnType= resultSetMetaData.getColumnTypeName(i);
    	System.out.println("Column Number is:"+i);
    	System.out.println("Column Name is:"+columnName);
    	System.out.println("Column Type is:"+columnType);
    	System.out.println();
       }
       statement.close();
       connection.close();
       
         
    	   
       }
	}
    //validating the given table name
	private static boolean isValidTableName(Connection connection, String tableName, String schemaName) {
		try{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SHOW TABLES LIKE '" +tableName+ "'");
			return resultSet.next(); 
		}catch (SQLException e) {
			if (e.getErrorCode() == 1146) { // Table doesn't exist
				System.out.println("Error: Table" +tableName+ "does not exist in the schema '" + schemaName + "'.");
			}
		}
		return false;
	}
}
