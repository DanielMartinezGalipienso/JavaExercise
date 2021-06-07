package com.example.posong;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String>{
	
	//To-Do
	//Required a method for compare score of songs for replace if win with a better punctuation
	
}
