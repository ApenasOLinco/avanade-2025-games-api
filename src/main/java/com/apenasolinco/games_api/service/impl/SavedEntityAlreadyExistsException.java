package com.apenasolinco.games_api.service.impl;

import com.apenasolinco.games_api.exception.BusinessException;

public class SavedEntityAlreadyExistsException extends BusinessException {

	private static final String TEMPLATE = "An entity with the type \"%s\" and the name \"%s\" already exists in the database. Saving a new one would be redundant.";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7485584446670896043L;

	public SavedEntityAlreadyExistsException(String entityType, String entityName) {
		super(String.format(TEMPLATE, entityType, entityName));
	}
	
}

















