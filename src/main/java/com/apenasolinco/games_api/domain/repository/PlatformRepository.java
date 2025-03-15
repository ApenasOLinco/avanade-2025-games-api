package com.apenasolinco.games_api.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apenasolinco.games_api.domain.model.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Long>{

	public Optional<Platform> findByName(String name);
	
}
