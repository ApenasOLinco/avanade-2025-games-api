package com.apenasolinco.games_api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apenasolinco.games_api.domain.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
	
	public List<Game> findAllByGenresId(Long genresId);
	
}
