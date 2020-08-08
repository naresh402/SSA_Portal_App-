package com.ashokit.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
	

	@ExceptionHandler(value=InvalidSSN.class)
	public ResponseEntity<ApiError> handleInvalidSSN() {
		
		ApiError error=new ApiError(400,"Invalid SSN Found ",new Date());
		return new  ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
	}

}
