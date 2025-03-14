package com.apenasolinco.games_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apenasolinco.games_api.domain.model.Game;
import com.apenasolinco.games_api.domain.repository.GameRepository;
import com.apenasolinco.games_api.exception.GameNotFoundException;
import com.apenasolinco.games_api.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository repository;

	public Game getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new GameNotFoundException(id));
	}
	
	public Game save(Game game) {
		return repository.save(game);
	}

}


































