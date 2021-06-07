package com.example.posong;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webapi")
public class PlayerRestController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@GetMapping("/players")
	public Iterable<Player> getAllPlayers() {
		return playerRepository.findAll();
	}
	
	@GetMapping("/player/{id}")
	public Optional<Player> getThisPlayer(@PathVariable String id){
		return playerRepository.findById(id);
	}
	/*
	@PostMapping("/addplayerscores")
	public ResponseEntity<Player> addThisPlayer(@RequestBody PlayerWrapper playerToAdd){
		Player playerToInsert = playerToAdd.getPlayer();
		
		int count = 0;
		while(count < playerToAdd.getScores().size()) {
			Score scoreToAdd = playerToAdd.getScores().get(count);
			playerToInsert.getScores().add(scoreToAdd);
			count++;
		}
		
		playerRepository.save(playerToInsert);
		return new ResponseEntity<Player>(HttpStatus.CREATED);
	}
	*/
	@PostMapping("/addplayer")
	public ResponseEntity<Player> addThisPlayer(@RequestBody Player playerToAdd){
		
		playerRepository.save(playerToAdd);
		
		return new ResponseEntity<Player>(HttpStatus.CREATED);
	}
	
	/*
	@PostMapping
	public ResponseEntity<Player> addThisPlayer(@RequestBody Player playerToAdd){
		playerRepository.save(playerToAdd);
		return new ResponseEntity<Player>(HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public Player updateThisPlayer(@RequestBody Player playerToUpdate, @PathVariable String id) {
		Optional<Player> playerFound = playerRepository.findById(id);
		if(playerFound.isPresent()) {
			playerRepository.deleteById(id);
		}
		playerToUpdate.setId(id);
		return playerRepository.save(playerToUpdate);
	}
	
	@PutMapping("/updateplayer/{id}")
	public Player updateThisPlayer(@RequestBody PlayerWrapper playerToInsert, @PathVariable String id) {
		Optional<Player> playerFound = playerRepository.findById(id);
		if(playerFound.isPresent()) {
			playerRepository.deleteById(id);
		}
		Player playerToUpdate = playerToInsert.getPlayer();
		playerToUpdate.setId(id);
		int count = 0;
		
		while (count < playerToInsert.getScores().size()) {
			Score scoreToUpdate = playerToInsert.getScores().get(count);
			playerToUpdate.getScores().add(scoreToUpdate);
			count++;
		}
		
		return playerRepository.save(playerToUpdate);
	}
	*/
	
	@PutMapping("/updateplayer/{id}")
	public ResponseEntity<Player> updateThisPlayer(@RequestBody Player playerToInsert, @PathVariable String id) {
		//System.out.println(playerToInsert);
		playerRepository.save(playerToInsert);
		return new ResponseEntity<Player>(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/deleteplayer/{id}")
	public ResponseEntity<Player> deleteThisPlayer(@PathVariable String id) {
		Optional<Player> playerToDelete = playerRepository.findById(id);
		if(playerToDelete.isPresent()) {
			playerRepository.deleteById(id);
			return new ResponseEntity<Player>(HttpStatus.OK);
		}
		return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/deleteallplayers")
	public ResponseEntity<Player> deletePlayers(){
		
		playerRepository.deleteAll();
		return new ResponseEntity<Player>(HttpStatus.OK);
	}
	

}
