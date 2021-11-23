package com.accenture.nace.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.accenture.nace.exception.EmptyInputException;
import com.accenture.nace.exception.NoResourceException;

@ControllerAdvice
public class NaceControllerAdvice ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		return new ResponseEntity<String>("Input Field/fields are empty, please look into it", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoResourceException.class)
	ResponseEntity<String> ResourceNotAvailable(NoResourceException noResourceException){
		return new ResponseEntity<String>("No Orders available to display", HttpStatus.NO_CONTENT);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	ResponseEntity<String> handleNoSuchElement(NoSuchElementException noSuchElementException){
		return new ResponseEntity<String>("Entered order is not available, Please Enter correct details", HttpStatus.NOT_FOUND);
	}
	
}
