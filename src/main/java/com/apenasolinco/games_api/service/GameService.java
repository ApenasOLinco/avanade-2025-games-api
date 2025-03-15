package com.apenasolinco.games_api.service;

import java.util.List;

import com.apenasolinco.games_api.domain.model.Game;

public interface GameService {
	
	public Game getById(Long id);
	
	public Game save(Game game);
	
	public List<Game> findByGenresId(Long genresId);
	
}
