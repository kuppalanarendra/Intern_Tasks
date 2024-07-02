package com.example.banking_app.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class AccountExceptions {
	@ResponseStatus
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String,String> validation(ConstraintViolationException e ){
		Map<String,String> errorMap= new HashMap<>();
		Set<ConstraintViolation<?>>  voilations= e.getConstraintViolations();
		for(ConstraintViolation violation:voilations) {
			errorMap.put(violation.getMessageTemplate(), violation.getMessage());
		}
		return errorMap;
		 
	}

}
