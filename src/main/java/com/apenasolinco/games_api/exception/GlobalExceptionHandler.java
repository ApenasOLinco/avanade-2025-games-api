package com.apenasolinco.games_api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(GameNotFoundException.class)
	public ResponseEntity<String> handleGameNotFoundException(GameNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnexpectedException(Throwable error) {
		logger.error(error.getMessage(), error);
		
		return new ResponseEntity<>("Unexpected exception. Please, check the server logs.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}























