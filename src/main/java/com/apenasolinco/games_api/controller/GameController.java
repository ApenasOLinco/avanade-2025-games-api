package com.apenasolinco.games_api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.apenasolinco.games_api.domain.model.Game;
import com.apenasolinco.games_api.service.GameService;


@RestController
@RequestMapping("/games")
public class GameController {
	
	@Autowired
	private GameService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Game> getById(@PathVariable Long id) {
		var game = service.getById(id);
		
		return ResponseEntity.ok(game);
	}
	
	@PostMapping
	public ResponseEntity<Game> create(@RequestBody Game game) {
		Game createdGame = service.save(game);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdGame.getId())
				.toUri();
		
		return ResponseEntity.created(location).body(createdGame);
	}

}










































