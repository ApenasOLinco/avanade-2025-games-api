package com.apenasolinco.games_api.service;

import com.apenasolinco.games_api.domain.model.Game;

public interface GameService {
	
	public Game getById(Long id);
	
	public Game save(Game game);
	
}
