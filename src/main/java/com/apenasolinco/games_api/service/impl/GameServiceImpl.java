package com.apenasolinco.games_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apenasolinco.games_api.domain.model.Game;
import com.apenasolinco.games_api.domain.model.Genre;
import com.apenasolinco.games_api.domain.repository.GameRepository;
import com.apenasolinco.games_api.domain.repository.GenreRepository;
import com.apenasolinco.games_api.service.GameService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Override
	public Game getById(Long id) {
		return gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	@Transactional
	public Game save(Game game) {
		var genres = game.getGenres();
		var updatedGenres = new ArrayList<Genre>();

		for (int i = 0; i < genres.size(); i++) {
			var genre = genres.get(i);
			var existingGenre = genreRepository.findByName(genre.getName());

			if (existingGenre.isPresent()) {
				updatedGenres.add(existingGenre.get());
			} else {
				updatedGenres.add(genre);
			}
		}

		game.setGenres(updatedGenres);
		return gameRepository.save(game);
	}

	@Override
	public List<Game> findByGenresId(Long genreId) {
		return gameRepository.findAllByGenresId(genreId);
	}

}
