package com.employeedirectory.advice;

import org.springframework.http.HttpStatus;

public class ExceptionMessage {
	
	//variables 
	private HttpStatus status;
	private String exception;
	private String message;
	
	
	
	//Paraamterized Construuctor
	public ExceptionMessage(HttpStatus status, String exception, String message) {
		super();
		this.status = status;
		this.exception = exception;
		this.message = message;
	}
	//Getters and Setters
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
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
