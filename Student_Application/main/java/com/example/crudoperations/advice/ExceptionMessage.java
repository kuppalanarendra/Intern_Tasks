package com.example.crudoperations.advice;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {

	private HttpStatus statusCode; // statuscode of the request
	private String exception; // Name of the exception
	private String message;// description of the exception

	// Constructor
	public ExceptionMessage(HttpStatus statusCode, String exception, String message) {
		super();
		this.statusCode = statusCode;
		this.exception = exception;
		this.message = message;
	}

	// Getters and Setters
	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
