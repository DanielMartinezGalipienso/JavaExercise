package example.com.posongclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/extra")
public class ExtraController {
	
	@Autowired
	private ExtraService extraService;
	
	//To-Do all
	
	@RequestMapping("/restore")
	public String restoreDBMain(Model model) {
		
		model.addAttribute("text", "Restore Database");
		return "restore";
	}
	
	@RequestMapping("/restoreplayers")
	public String restoreBDPlayers(Model model) {
		
		extraService.resetDBPlayers();
		model.addAttribute("text", "Database Players restored.");
		return "restore";
	}
	
	@RequestMapping("/restoresongs")
	public String restoreDBSongs(Model model) {
		
		extraService.resetDBSong();
		model.addAttribute("text", "Database Songs restored.");
		return "restore";
	}
}
