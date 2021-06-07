package com.example.posong;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "score")
public class Score {
	
	private String nameSong;
	private int timesPlayed = 0;
	private int scoreForDifficultyA = 0;
	private int scoreForDifficultyB = 0;
	private int scoreForDifficultyC = 0;
	private int scoreForDifficultyD = 0;

	@Override
	public String toString() {
		return "Score [nameSong=" + nameSong + ", timesPlayed=" + timesPlayed + ", scoreForDifficultyA="
				+ scoreForDifficultyA + ", scoreForDifficultyB=" + scoreForDifficultyB + ", scoreForDifficultyC="
				+ scoreForDifficultyC + ", scoreForDifficultyD=" + scoreForDifficultyD + "]";
	}
	public String getNameSong() {
		return nameSong;
	}
	public void setNameSong(String nameSong) {
		this.nameSong = nameSong;
	}
	public int getTimesPlayed() {
		return timesPlayed;
	}
	public void setTimesPlayed(int timesPlayed) {
		this.timesPlayed = timesPlayed;
	}
	public int getScoreForDifficultyA() {
		return scoreForDifficultyA;
	}
	public void setScoreForDifficultyA(int scoreForDifficultyA) {
		this.scoreForDifficultyA = scoreForDifficultyA;
	}
	public int getScoreForDifficultyB() {
		return scoreForDifficultyB;
	}
	public void setScoreForDifficultyB(int scoreForDifficultyB) {
		this.scoreForDifficultyB = scoreForDifficultyB;
	}
	public int getScoreForDifficultyC() {
		return scoreForDifficultyC;
	}
	public void setScoreForDifficultyC(int scoreForDifficultyC) {
		this.scoreForDifficultyC = scoreForDifficultyC;
	}
	public int getScoreForDifficultyD() {
		return scoreForDifficultyD;
	}
	public void setScoreForDifficultyD(int scoreForDifficultyD) {
		this.scoreForDifficultyD = scoreForDifficultyD;
	}
	
	

}
