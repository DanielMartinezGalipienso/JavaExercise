package example.com.posongclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/song")
public class SongController {
	
	@Autowired
	private SongService songService;
	

	/*
	 *  - - - -     - - - -
	- - - - - - GET - - - - - -
	 *  - - - -     - - - -
	*/
	
	@RequestMapping("/show/all")
	public String showAllSongs(Model model) {
		
		Iterable<Song> songs = songService.querySongs();
		model.addAttribute("song", songs);
		
		return "songAll";
		
	}
	
	@RequestMapping("/show")
	public String showThisSong(@RequestParam("id") String idFromView, Model model) {
		
		Song song = songService.querySongById(idFromView);
		model.addAttribute("song", song);
		model.addAttribute("title", "Show " + song.getName() +" song");
		
		return "songId";
		
	}

	/*
	 *  - - - -      - - - -
	- - - - - - POST - - - - - -
	 *  - - - -      - - - -
	*/
	
	@RequestMapping("/add")
	public String createSongForm() {
		
		return "songNew";
		
	}
	
	@RequestMapping("/new")
	public String createSong(Song songToAdd, Model model) {
		
		 songService.queryAddOneSong(songToAdd);
		 model.addAttribute("song", songService.querySongs());
		 
		 return "songAll";
		 
	}

	/*
	 *  - - - -     - - - -
	- - - - - - PUT - - - - - -
	 *  - - - -     - - - -
	*/
	
	//Song
	
	@RequestMapping("/update")
	public String updateThisSong(@RequestParam("id") String idFromView, Model model) {
		
		Song song = songService.querySongById(idFromView);
		model.addAttribute("song", song);
		model.addAttribute("title", "Update " + song.getName() + " song info");
		
		return "songUpdate";
		
	}
	
	@RequestMapping("/updatesong")
	public String updatedThisSong(@RequestParam("id") String idFromView, Song songToUpdate, Model model) {
		
		songService.queryUpdateInformationOfSong(idFromView, songToUpdate);
		Song song = songService.querySongById(idFromView);
		model.addAttribute("song", song);
		model.addAttribute("title", "Show " + song.getName() + " song");
		
		return "songId";
		
	}
	
	//SongDetails
	
	@RequestMapping("/updatedetail")
	public String addThisSongDetail(@RequestParam("id") String idFromView, Model model) {
		
		Song song = songService.querySongById(idFromView);
		model.addAttribute("song", song);
		model.addAttribute("title", "Update " + song.getName() + " song info");
		
		return "songAddSongDetail";
		
	}
	
	@RequestMapping("/addsongdetail")
	public String updateSongDetailOfThisSong(@RequestParam("id") String idFromView, SongDetails songDetails, Model model) {
		System.out.println("SongDetails to Add: " + songDetails);
		
		songService.queryAddSongDetails(idFromView, songDetails);
		Song song = songService.querySongById(idFromView);
		model.addAttribute("song", song);
		model.addAttribute("title", "Show " + song + " song");
		
		return "songId";
		
	}
	
	/*
	 *  - - - -        - - - -
	- - - - - - DELETE - - - - - -
	 *  - - - -        - - - -
	*/
	
	@RequestMapping("/delete")
	public String removeThisSong(@RequestParam("id") String idFromView, Model model) {
		
		String nameSongToDelete = " " + songService.querySongById(idFromView).getName() + " ";
		ResponseEntity<Song> response = songService.queryDeleteSongById(idFromView);
		model.addAttribute("nameSong", nameSongToDelete);
		model.addAttribute("title", "Song " + nameSongToDelete + " deleted");
		model.addAttribute("song", response);
		
		return "songDeleted";
		
	}
}
