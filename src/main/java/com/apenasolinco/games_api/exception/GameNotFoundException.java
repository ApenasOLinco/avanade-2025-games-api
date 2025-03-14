package com.apenasolinco.games_api.exception;

public class GameNotFoundException extends BusinessException {
	
	private static final long serialVersionUID = 788989556905049466L;

	public GameNotFoundException(Long id) {
		super(String.format("No game found with the id %d.", id));
	}
	
}
