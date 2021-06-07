package example.com.posongclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/player")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	/*
	 *  - - - -     - - - -
	- - - - - - GET - - - - - -
	 *  - - - -     - - - -
	*/
	
	@RequestMapping("/show/all")
	public String showAllPlayers(Model model) {
		
		Iterable<Player> players = playerService.queryPlayers(); 
		model.addAttribute("player", players);
		
		System.out.println(players);
		
		return "playerAll";
	}
	
	@RequestMapping("/show/scores")
	public String showAllPlayersScore(Model model) {
		Iterable<Player> players = playerService.queryPlayers();
		model.addAttribute("player", players);
		
		System.out.println(players);
		
		return "playerScoreAll";
	}
	
	@RequestMapping("/show")
	public String ShowThisPlayer(@RequestParam("id") String idFromView, Model model) {
		
		Player player = playerService.queryPlayerById(idFromView);
		model.addAttribute("player", player);
		
		System.out.println(player);
		
		return "playerId";
	}
	
	/*
	 *  - - - -      - - - -
	- - - - - - POST - - - - - -
	 *  - - - -      - - - -
	*/
	
	@RequestMapping("/add")
	public String createPlayerForm(){
		
		return "playerNew";
	}
	
	@RequestMapping("/new")
	public String createPlayer(Player playerToAdd, Model model) {
		
		//Player response =
		playerService.queryAddOnePLayer(playerToAdd);
		
		//model.addAttribute("playerController", response);
		//System.out.println("Response : " + response);
		model.addAttribute("player", playerService.queryPlayers());
			
		return "playerAll";
	}

	/*
	 *  - - - -     - - - -
	- - - - - - PUT - - - - - -
	 *  - - - -     - - - -
	*/
	
	@RequestMapping("/update")
	public String updateThisPlayer(@RequestParam("id") String idFromView, Model model) {
		
		Player player = playerService.queryPlayerById(idFromView);
		model.addAttribute("player", player);
		
		return "playerUpdate";
	}
	@RequestMapping("/updateplayer")
	public String updatedThisPlayer(@RequestParam("id") String idFromView, Player playerToUpdate, Model model) {
		
		System.out.println("Player To Update recived in controller: " + playerToUpdate);
		/*
		if(playerToUpdate.getScores().isEmpty()) {
			
		}
		*/
		
		playerService.queryUpdateInformationOfPlayer(idFromView, playerToUpdate);
		model.addAttribute("player", playerService.queryPlayerById(idFromView));
		
		return "playerId";
		/*
		 * System.out.println("Player to update: " + playerToUpdate);
		 * ResponseEntity<Player> response =
		 * playerService.queryUpdateInformationOfPlayer(idFromView, playerToUpdate);
		 * System.out.println(response.getBody());
		 * model.addAttribute("playerFromController", response);
		 * System.out.println("Response: " + response);
		 * 
		 * return "playerAll";
		 */
	}
	
	@RequestMapping("/updatescore")
	public String addThisPlayerScore(@RequestParam("id") String idFromView, Model model) {
		Player player = playerService.queryPlayerById(idFromView);
		model.addAttribute("player", player);
		
		return "playerAddScore";
	}
	
	@RequestMapping("/addscore")
	public String updateScoreOfThisPlayer(@RequestParam("id") String idFromView, Score playerScore, Model model) {
		
		playerService.queryAddPlayerScore(idFromView, playerScore);
		model.addAttribute("player", playerService.queryPlayerById(idFromView));
		
		
		return "playerId";
		
		/*
		 * ResponseEntity<Player> response =
		 * playerService.queryUpdatePlayerScore(idFromView, playerScore);
		 * 
		 * model.addAttribute("playerFromController", response);
		 * if(response.getStatusCode().is2xxSuccessful()){ return "playerUpdated"; }
		 * return "error";
		 */
	}

	/*
	 *  - - - -        - - - -
	- - - - - - DELETE - - - - - -
	 *  - - - -        - - - -
	*/
	
	@RequestMapping("/delete")
	public String removeThisPlayer(@RequestParam("id") String idFromView, Model model) {
		String namePlayerToDelete = " "+ playerService.queryPlayerById(idFromView).getName() + " ";
		
		ResponseEntity<Player> response = playerService.queryDetelePlayerById(idFromView);
		model.addAttribute("namePlayer", namePlayerToDelete);
		System.out.println("Delete status: " +response.getStatusCode());
		
		//model.addAttribute("playerFromController", response);
		return "playerDeleted";
	}
	
}
