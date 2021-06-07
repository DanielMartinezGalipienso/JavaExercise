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
public class SongRestController {
	
	@Autowired
	private SongRepository songRepository;
	
	  // - - - //
	 //  GET  //
	// - - - //
	
	@GetMapping("/songs")
	public Iterable<Song> getAllTheSongs(){
		return songRepository.findAll();
	}
	
	@GetMapping("/song/{id}")
	public Optional<Song> getThisSong(@PathVariable String id){
		return songRepository.findById(id);
	}
	
	
	  // - - - //
	 //  POST //
	// - - - //
	
	@PostMapping("/addsong")
	public ResponseEntity<Song> addThisSong(@RequestBody Song songToAdd) {
		songRepository.save(songToAdd);
		return new ResponseEntity<Song>(HttpStatus.CREATED);
	}
	//To-Do
	//Put with one Container --> in Players (Score)
	
	
	  // - - - //
	 //  PUT  //
	// - - - //
	
	@PutMapping("/updatesong/{id}")
	public ResponseEntity<Song> updateThisSong(@RequestBody Song songReceivedToUpdate, @PathVariable String id) {
		
		songRepository.save(songReceivedToUpdate);
		return new ResponseEntity<Song>(HttpStatus.OK);
	}
	
	
	
	  // - - - //
	 //DELETE //
	// - - - //
	
	@DeleteMapping("/deletesong/{id}")
	public ResponseEntity<Song> deleteThisSong(@PathVariable String id) {
		Optional<Song> songToDelete = songRepository.findById(id);
		
		if(songToDelete.isPresent()) {
			songRepository.deleteById(id);
			return new ResponseEntity<Song>(HttpStatus.OK);
		}
		return new ResponseEntity<Song>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/deleteallsongs")
	public ResponseEntity<Song> deleteSongs(){
		
		songRepository.deleteAll();
		
		return new ResponseEntity<Song>(HttpStatus.OK);
	}
	
	
	
}
