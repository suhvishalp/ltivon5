package com.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GenericException {

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GenericExceptionResponse> myGenericExceptionHandler(Exception ex){
		
		GenericExceptionResponse res = new GenericExceptionResponse(null, ex.getMessage(), "some detailis");
		return new ResponseEntity<GenericExceptionResponse>(res, HttpStatus.BAD_REQUEST);
		
	}
}
