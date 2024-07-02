package com.employeedirectory.exceptions;
//ResourceNotFoundException class which throws custom exceptions
public class ResourceNotFoundException extends Exception {

	//constructor
	public ResourceNotFoundException(String message) {
		super(message); // this message calls the Exception class getMessage() method
		
	}
	

}
