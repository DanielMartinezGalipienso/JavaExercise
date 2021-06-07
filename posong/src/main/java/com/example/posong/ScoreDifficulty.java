package com.example.posong;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scoreDifficulty")
public class ScoreDifficulty {
	
	private int difficulty;
	private int score;
	

	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
