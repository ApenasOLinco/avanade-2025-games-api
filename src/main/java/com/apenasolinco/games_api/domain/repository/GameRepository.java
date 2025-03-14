package com.apenasolinco.games_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apenasolinco.games_api.domain.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
