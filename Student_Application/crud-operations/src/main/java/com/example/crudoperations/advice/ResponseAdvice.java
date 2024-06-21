package com.example.crudoperations.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.crudoperations.exceptions.StudentNotFoundException;

@RestControllerAdvice // @RestControllerAdvice. This annotation is used to create a global exception
						// handler that will handle exceptions thrown by any controller and return a
						// proper HTTP response.
public class ResponseAdvice {

	@ResponseStatus
	@ExceptionHandler(StudentNotFoundException.class)

	// The @ExceptionHandler annotation in Spring Boot is used within a
	// @RestControllerAdvice or @ControllerAdvice class to handle
	// specific exceptions thrown by any controller in a centralized manner.
	// This helps to keep the exception handling code separate from the business
	// logic.
	public ResponseEntity studentNotFound(StudentNotFoundException e) {
		ExceptionMessage exceptionMessage = new ExceptionMessage(HttpStatus.NOT_FOUND, "StudentNotFoundException",
				e.getMessage());
		return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
	}

}
