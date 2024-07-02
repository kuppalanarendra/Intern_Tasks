package com.employeedirectory.advice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employeedirectory.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ResponseAdvice {
	
	@ResponseStatus
	@ExceptionHandler(MethodArgumentNotValidException.class)
	//userValidation method handles the validations for user specific data
	public Map<String,String> userValidation(MethodArgumentNotValidException e) {
		Map<String,String> errorMap= new HashMap<>();
		
		List<FieldError> errors=e.getBindingResult().getFieldErrors();
		for(FieldError error:errors) {
		errorMap.put(error.getField(), error.getDefaultMessage());
		}
		
		return errorMap;
		
	}
	
	@ResponseStatus
	@ExceptionHandler(ResourceNotFoundException.class)
	//resourceNotFound exception method handles exception when user not found with given id
	public ResponseEntity resourceNotFound(ResourceNotFoundException resourceNotFoundException) {
		 ExceptionMessage exceptionMessage= new ExceptionMessage(HttpStatus.NOT_FOUND, "ResourceNotFoundException", resourceNotFoundException.getMessage());
		return new ResponseEntity<>(exceptionMessage,HttpStatus.NOT_FOUND);
		 
	}

}
