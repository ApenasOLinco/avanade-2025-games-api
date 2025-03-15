package com.apenasolinco.games_api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apenasolinco.games_api.domain.model.Genre;
import com.apenasolinco.games_api.domain.repository.GenreRepository;
import com.apenasolinco.games_api.service.GenreService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repository;

	@Override
	public Genre save(Genre genre) {
		boolean exists = repository.existsByName(genre.getName());

		if (exists)
			throw new SavedEntityAlreadyExistsException("Genre", genre.getName());

		return repository.save(genre);
	}

	@Override
	public Genre getById(Long id) {
		return repository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

}
