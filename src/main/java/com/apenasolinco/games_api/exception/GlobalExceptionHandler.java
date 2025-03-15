package com.apenasolinco.games_api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.apenasolinco.games_api.service.impl.SavedEntityAlreadyExistsException;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(SavedEntityAlreadyExistsException.class)
	public ResponseEntity<String> handleSavedEntityAlreadyExistsException(SavedEntityAlreadyExistsException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handleUnexpectedException(Throwable error) {
		logger.error(error.getMessage(), error);
		
		return new ResponseEntity<>("Unexpected internal error. Please, check the server logs.", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}























