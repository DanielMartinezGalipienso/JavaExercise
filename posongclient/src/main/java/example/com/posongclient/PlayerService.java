package example.com.posongclient;

import java.util.ArrayList;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlayerService {
	
	RestTemplate template = new RestTemplate();

	/*
	 *  - - - -     - - - -
	- - - - - - GET - - - - - -
	 *  - - - -     - - - -
	*/
	
	public Iterable<Player> queryPlayers() {
		/*
		 * 1st receive the URI of players in JSON
		 * 2nd Get Method in HTTP -> HttpMethod.Get
		 * 3rd RequestEntity
		 * 4th Parameterized of data of JSON
		*/
		ResponseEntity<List<Player>> response = template.exchange(
				Util.urlWebapi() + "/players",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Player>>() {});
		
		List<Player> playersResponse = response.getBody();
		
		return playersResponse;
	}
	
	public Player queryPlayerById(String idToFind) {
		String url = Util.urlWebapi() + "/player/" + idToFind;
		ResponseEntity<Player> response = template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Player>() {});
		Player playerResponse = response.getBody();
		
		//System.out.println(playerResponse);
		
		return playerResponse;
	}

	/*
	 *  - - - -      - - - -
	- - - - - - POST - - - - - -
	 *  - - - -      - - - -
	*/
	
	public Player queryAddOnePLayer(Player player) {
		//System.out.println(template.postForObject("http://localhost:8090/webapi/addplayer", player, Player.class));
		String url = Util.urlWebapi() + "/addplayer";
		
		if(player.getScores().isEmpty()) {
			player.setScores(this.defaultScore());
		}
		
		//System.out.println("Url: "+ url);
		//ResponseEntity<Player> response = template.exchange(url, HttpMethod.POST, null, new ParameterizedTypeReference<Player>() {});
		Player response = template.postForObject(url, player, Player.class);
		//Player playerResponse = response.getBody();
		
		return response;
		
	}
	
	/*
	 *  - - - -     - - - -
	- - - - - - PUT - - - - - -
	 *  - - - -     - - - -
	*/
		
	public void queryUpdateInformationOfPlayer(String idPlayer, Player playerReceived) {
		
		/*
		 * Player playerToUpdateInDB = this.queryPlayerById(idPlayer);
		 * System.out.println("Player recived from DB to Update: " +
		 * playerToUpdateInDB);
		 * 
		 * if(!playerReceived.getName().equals("") &&
		 * !playerToUpdateInDB.getName().equals(playerReceived.getName())) {
		 * playerToUpdateInDB.setName(playerReceived.getName()); }
		 * if(!playerReceived.getEmail().equals("") &&
		 * !playerToUpdateInDB.getEmail().equals(playerReceived.getEmail())) {
		 * playerToUpdateInDB.setEmail(playerReceived.getEmail()); }
		 */
		
		/*
		 * if(playerToUpdateInDB.getScores() == null) {
		 * playerToUpdateInDB.initializeScoresIfNotHave();; }
		 */
		System.out.println("Id player: " + idPlayer);
		Player playerFromDB = this.queryPlayerById(idPlayer);
		System.out.println("Player From DB: " + playerFromDB);
		playerReceived.setScores(playerFromDB.getScores());
		//Default Score
		if(playerReceived.getScores() == null) {
			playerReceived.setScores(this.defaultScore());
		}
		
		System.out.println("\nPlayer to send to DB: " + playerReceived);
		
		String url = Util.urlWebapi() + "/updateplayer/" + idPlayer;
		template.put(url, playerReceived);
		//ResponseEntity<Player> response = template.exchange(url, HttpMethod.PUT, null, new ParameterizedTypeReference<Player>() {});
		//template.put(url, playerToUpdateInDB);
		
		//Player playerResponse = response.getBody();
		
		
		//return response;
	}
	
	public void queryAddPlayerScore(String idPlayer, Score scoreToAdd) {
		Player playerToUpdate = this.queryPlayerById(idPlayer);
		System.out.println("Score to add: " + scoreToAdd);
		System.out.println("Player to Update: " + playerToUpdate);
		
		if(playerToUpdate.getScores() == null) {
			playerToUpdate.setScores(this.defaultScore());
		}
		
		int count = 0;
		List<Score> playerScores = playerToUpdate.getScores();
		boolean scoreAdded = false;
		while(count < playerScores.size()) {
			System.out.println("Score song: " + playerScores.get(count).getNameSong());
			Score playerScoreFromArray = playerScores.get(count);
			
			
			if(scoreToAdd.getNameSong().equals(playerScoreFromArray.getNameSong())) {
				//Add one more time if the score is Up of 0
				//Set All Difficulties if the new score is Better
				
				//DifficultyA
				if(scoreToAdd.getScoreForDifficultyA() > 0) {
					playerScoreFromArray.addOneMoreTimePlayed();
					if(scoreToAdd.getScoreForDifficultyA() >= playerScoreFromArray.getScoreForDifficultyA()) {
						playerToUpdate.getScores().get(count).setScoreForDifficultyA(scoreToAdd.getScoreForDifficultyA());
						
					}
				}
				//DifficultyB
				if(scoreToAdd.getScoreForDifficultyB() > 0) {
					playerScoreFromArray.addOneMoreTimePlayed();
					if(scoreToAdd.getScoreForDifficultyB() >= playerScoreFromArray.getScoreForDifficultyB()) {
						playerToUpdate.getScores().get(count).setScoreForDifficultyB(scoreToAdd.getScoreForDifficultyB());
						
					}
				}
				//DifficultyC
				if(scoreToAdd.getScoreForDifficultyC() > 0) {
					playerScoreFromArray.addOneMoreTimePlayed();
					if(scoreToAdd.getScoreForDifficultyC() >= playerScoreFromArray.getScoreForDifficultyC()) {
						playerToUpdate.getScores().get(count).setScoreForDifficultyC(scoreToAdd.getScoreForDifficultyC());
						
					}
				}
				//DifficultyD
				if(scoreToAdd.getScoreForDifficultyD() > 0) {
					playerScoreFromArray.addOneMoreTimePlayed();
					if(scoreToAdd.getScoreForDifficultyD() >= playerScoreFromArray.getScoreForDifficultyD()) {
						playerToUpdate.getScores().get(count).setScoreForDifficultyD(scoreToAdd.getScoreForDifficultyD());
						
					}
				}
				scoreAdded = true;
				
			}
			count++;
		}
		//If the score for this song doesn't exist previously... Simply add this.
		if(!scoreAdded) {
			playerToUpdate.getScores().add(scoreToAdd);
		}

		String url = Util.urlWebapi() + "/updateplayer/" + playerToUpdate;
		template.put(url, playerToUpdate);
			
		
		
	}
	
	/*
	public void queryUpdatePlayerScore(String idPlayer, Player playerReceived) {
		Player playerToUpdateInDB = this.queryPlayerById(idPlayer);
		System.out.print("Player to Update:\n");
		System.out.println("Player to Update:\n" + playerToUpdateInDB);
		playerToUpdateInDB.setId(idPlayer);
		playerReceived.setScores(playerToUpdateInDB.getScores());
		
		int counta = 0;
		List<Score> scoreListToUpdateInDB = playerToUpdateInDB.getScores();
		//While for a List of Score of the Player in DB
		while (counta < scoreListToUpdateInDB.size()) {
			Score scoreToUpdateInDB = scoreListToUpdateInDB.get(counta);
			int countb = 0;
			List<Score> scoreListReceived = playerReceived.getScores();
			//While for a List of Score of the Player received
			while(countb < scoreListReceived.size()) {
				Score scoreReceived = scoreListReceived.get(countb);
				if(scoreToUpdateInDB.getNameSong().equals(scoreReceived.getNameSong())) {
					
					//If the score received is better, update this
					//And add one more time played if the score is better of 0!
					// - Do the same to the 4 difficulties -
					// DIFFICULTY A
					if(scoreReceived.getScoreForDifficultyA() > 0) {
						if(scoreReceived.getScoreForDifficultyA() > scoreToUpdateInDB.getScoreForDifficultyA()) {
							scoreToUpdateInDB.setScoreForDifficultyA(scoreReceived.getScoreForDifficultyA());
						}
						scoreToUpdateInDB.addOneMoreTimePlayed();
					}
					//DIFFICULTY B
					if(scoreReceived.getScoreForDifficultyB() > 0) {
						if(scoreReceived.getScoreForDifficultyB() > scoreToUpdateInDB.getScoreForDifficultyB()) {
							scoreToUpdateInDB.setScoreForDifficultyB(scoreReceived.getScoreForDifficultyB());
						}
						scoreToUpdateInDB.addOneMoreTimePlayed();
					}
					//DIFFICULTY C
					if(scoreReceived.getScoreForDifficultyC() > 0) {
						if(scoreReceived.getScoreForDifficultyC() > scoreToUpdateInDB.getScoreForDifficultyC()) {
							scoreToUpdateInDB.setScoreForDifficultyC(scoreReceived.getScoreForDifficultyC());
						}
						scoreToUpdateInDB.addOneMoreTimePlayed();
					}
					//dIFFICULTY D
					if(scoreReceived.getScoreForDifficultyD() > 0) {
						if(scoreReceived.getScoreForDifficultyD() > scoreToUpdateInDB.getScoreForDifficultyD()) {
							scoreToUpdateInDB.setScoreForDifficultyD(scoreReceived.getScoreForDifficultyD());
						}
						scoreToUpdateInDB.addOneMoreTimePlayed();
					}
					//Delete this score of the Player received
					scoreListReceived.remove(countb);
					
					//
					// List<ScoreDifficulty> difficultyListToUpdateInDB =
					// scoreToUpdateInDB.getScoreForDifficulty(); int countc = 0; //While for a List
					// of ScoreDifficulty of the Player in DB while(countc <
					// difficultyListToUpdateInDB.size()) { List<ScoreDifficulty>
					// difficultyListRecived = scoreRecived.getScoreForDifficulty(); int countd = 0;
					// while(countd < difficultyListRecived.size()) { for(ScoreDifficulty
					// difficultyInDB : difficultyListToUpdateInDB) { ScoreDifficulty
					// difficultyRecived = difficultyListRecived.get(countd);
					// if(difficultyInDB.getDifficulty() == difficultyRecived.getDifficulty()) {
					// if(difficultyInDB.getScore() < difficultyRecived.getScore()) {
					// difficultyInDB.setScore(difficultyRecived.getScore()); }
					// difficultyListRecived.remove(countd); } } } countc++; }
					//
				} else {
					countb++;
				}
			}
			
			
			counta++;
		}
		
		//Once verify All the score who already exist, if already have more in the Player Received, add this to the Player to update in DB
		if(playerReceived.getScores().size() > 0) {
			List<Score> scoreListReceived = playerReceived.getScores();
			int countc = 0;
			while (scoreListReceived.size() > countc) {
				Score scoreReceived = scoreListReceived.get(countc);
				playerToUpdateInDB.getScores().add(scoreReceived);
				
				countc++;
			}
		}
		
		if(playerToUpdateInDB.getName().equals("") && !playerReceived.getName().equals("")) {
			playerToUpdateInDB.setName(playerReceived.getName());
		}
		if(playerToUpdateInDB.getEmail().equals("") && !playerReceived.getEmail().equals("")) {
			playerToUpdateInDB.setEmail(playerReceived.getEmail());
		}
		
		String url = Util.urlWebapi() + "/updateplayer/" + idPlayer;
		//ResponseEntity<Player> response = template.exchange(url, HttpMethod.PUT, null, new ParameterizedTypeReference<Player>() {});
		template.put(url, playerToUpdateInDB);
		
		//Player playerResponse = response.getBody();
		System.out.println("Player already Updated:\n" + playerToUpdateInDB);
		//return response;
	}
	*/
	
	
	/*
	 *  - - - -        - - - -
	- - - - - - DELETE - - - - - -
	 *  - - - -        - - - -
	*/
	
	public ResponseEntity<Player> queryDetelePlayerById(String idPlayer) {
		String url = Util.urlWebapi() + "/deleteplayer/" + idPlayer;
		
		//template.delete(url);
		ResponseEntity<Player> response = template.exchange(url, HttpMethod.DELETE, null, new ParameterizedTypeReference<Player>() {});
		
		//Player playerResponse = response.getBody();
		
		return response;
	}
	
	public ResponseEntity<Player> queryDeleteAllPlayers(){
		String url = Util.urlWebapi() + "/deleteallplayers";
		ResponseEntity<Player> response = template.exchange(url, HttpMethod.DELETE, null, new ParameterizedTypeReference<Player>() {});
		
		return response;
	}
	
	/*
	 *  - - - -       - - - -
	- - - - - - EXTRA - - - - - -
	 *  - - - -       - - - -
	*/
	public List<Score> defaultScore(){

		List<Score> score = new ArrayList<Score>();
		score.add(Util.defaultScore());
		return score;
	}
	
}
