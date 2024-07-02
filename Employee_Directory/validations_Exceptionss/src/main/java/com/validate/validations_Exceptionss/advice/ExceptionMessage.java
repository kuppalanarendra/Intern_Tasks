package com.validate.validations_Exceptionss.advice;

import org.springframework.http.HttpStatus;


// Class it contains Exception message
public class ExceptionMessage {
	private HttpStatus statuscode; //Response statuscode  
	private String exception; //Exception Name
	private String message;  //Description of the Exception
	
	//constructor
	public ExceptionMessage(HttpStatus statuscode, String exception, String message) {
		super();
		this.statuscode = statuscode;
		this.exception = exception;
		this.message = message;
	}
	
	//Getters and Setters
	public HttpStatus getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(HttpStatus statuscode) {
		this.statuscode = statuscode;
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
