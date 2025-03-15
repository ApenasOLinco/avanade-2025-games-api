package com.apenasolinco.games_api.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apenasolinco.games_api.domain.model.Game;
import com.apenasolinco.games_api.domain.model.Genre;
import com.apenasolinco.games_api.domain.model.Platform;
import com.apenasolinco.games_api.domain.repository.GameRepository;
import com.apenasolinco.games_api.domain.repository.GenreRepository;
import com.apenasolinco.games_api.domain.repository.PlatformRepository;
import com.apenasolinco.games_api.service.GameService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameRepository gameRepository;

	@Autowired
	private GenreRepository genreRepository;

	@Autowired
	private PlatformRepository platformRepository;

	@Override
	public Game getById(Long id) {
		return gameRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Override
	@Transactional
	public Game save(Game game) {
		// Verify the genres
		var genres = game.getGenres();
		genres.forEach(g -> g.setName(g.getName().toLowerCase()));
		
		var updatedGenres = new HashSet<Genre>();

		for (var genre : genres) {
			var existingGenre = genreRepository.findByName(genre.getName());
			updatedGenres.add(existingGenre.orElse(genre));
		}

		// Verify the platforms
		var platforms = game.getPlatforms();
		platforms.forEach(p -> p.setName(p.getName().toLowerCase()));
		
		var updatedPlatforms = new HashSet<Platform>();
		
		for (var platform : platforms) {
			var existingPlatform = platformRepository.findByName(platform.getName());
			updatedPlatforms.add(existingPlatform.orElse(platform));
		}

		game.setGenres(new ArrayList<>(updatedGenres));
		game.setPlatforms(new ArrayList<>(updatedPlatforms));
		
		return gameRepository.save(game);
	}

	@Override
	public List<Game> findByGenresId(Long genreId) {
		return gameRepository.findAllByGenresId(genreId);
	}

}
