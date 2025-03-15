package com.apenasolinco.games_api.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apenasolinco.games_api.domain.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	public Optional<Genre> findByName(String name);
	
	public boolean existsByName(String name);
	
}
