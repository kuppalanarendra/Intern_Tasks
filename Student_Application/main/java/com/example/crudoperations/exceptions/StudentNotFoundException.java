package com.example.crudoperations.exceptions;

public class StudentNotFoundException extends Exception {
	// StudentNotFoundException class extends Exception class to throw Custom
	// Exceptions

	public StudentNotFoundException(String message) {
		super(message);
	}

}
