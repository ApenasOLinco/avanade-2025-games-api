package com.apenasolinco.games_api.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -1875700117100759371L;
	
	public BusinessException(String message) {
		super(message);
	}
	
}
