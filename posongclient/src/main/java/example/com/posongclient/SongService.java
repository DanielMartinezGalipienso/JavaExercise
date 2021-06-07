package example.com.posongclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SongService {
	
	RestTemplate template = new RestTemplate();

	/*
	 *  - - - -     - - - -
	- - - - - - GET - - - - - -
	 *  - - - -     - - - -
	*/
	
	public Iterable<Song> querySongs(){
		String url = Util.urlWebapi() + "/songs";
		ResponseEntity<List<Song>> response = template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Song>>() {});
		List<Song> songsResponse = response.getBody();
		
		return songsResponse;
		
	}
	
	public Song querySongById(String idToFind) {
		String url = Util.urlWebapi() + "/song/" + idToFind;
		ResponseEntity<Song> response = template.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Song>() {});
		Song songResponse = response.getBody();
		
		return songResponse;
	}

	/*
	 *  - - - -      - - - -
	- - - - - - POST - - - - - -
	 *  - - - -      - - - -
	*/
	
	public Song queryAddOneSong(Song song) {
		

		int count = 0;
		while(count < song.getSingers().size()) {
			
			if(song.getSingers().get(count).equals("")) {
				song.getSingers().remove(count);
			} else {
				count++;
			}
		}
		
		String url = Util.urlWebapi() + "/addsong";
		Song response = template.postForObject(url, song, Song.class);
		
		return response;
		
	}

	/*
	 *  - - - -     - - - -
	- - - - - - PUT - - - - - -
	 *  - - - -     - - - -
	*/
	
	public void queryUpdateInformationOfSong(String idSong, Song songReceived) {
		System.out.println("Received song: " + songReceived);
		Song songToUpdate = this.querySongById(idSong);
		System.out.println("Song from DB: " + songToUpdate);
		
		if(songReceived.getName().equals("")) {
			songToUpdate.setName(songReceived.getName());
		}
		if(songReceived.getSingers() != null) {
			songToUpdate.setSingers(songReceived.getSingers());
		}
		
		int count = 0;
		while(count < songToUpdate.getSingers().size()) {
			
			if(songToUpdate.getSingers().get(count).equals("")) {
				songToUpdate.getSingers().remove(count);
			} else {
				count++;
			}
		}
		
		if(songToUpdate.getInfo() == null) {
			songToUpdate.setInfo(this.defaultSongDetail());
		}
		
		System.out.println("Song to update in DB: " + songToUpdate);
		
		String url = Util.urlWebapi() + "/updatesong/" + songToUpdate;
		template.put(url, songToUpdate);
		
	}
	
	public void queryAddSongDetails(String idSong, SongDetails songDetailToAdd) {
		Song songToUpdate = this.querySongById(idSong);
		
		if(songToUpdate.getInfo() == null) {
			songToUpdate.setInfo(this.defaultSongDetail());
		}
		
		int count = 0;
		boolean songDetailAdded = false;
		while(count < songToUpdate.getInfo().size()) {
			SongDetails songDetails = songToUpdate.getInfo().get(count);
			//If the Detail already exist, update this
			if(songDetails.getDetail().equals(songDetailToAdd.getDetail())) {
				songToUpdate.getInfo().get(count).setDetail(songDetailToAdd.getDetail());
				songToUpdate.getInfo().get(count).setValue(songDetailToAdd.getValue());
				songDetailAdded = true;
			}
			count++;
		}
		
		//If the Detail of the song doesn't exist previously, add this.
		if(!songDetailAdded) {
			songToUpdate.getInfo().add(songDetailToAdd);
		}
		
		String url = Util.urlWebapi() + "/updatesong/" + idSong;
		template.put(url, songToUpdate);
		
	}

	/*
	 *  - - - -        - - - -
	- - - - - - DELETE - - - - - -
	 *  - - - -        - - - -
	*/
	
	public ResponseEntity<Song> queryDeleteSongById(String idSong) {
		String url = Util.urlWebapi() + "/deletesong/" + idSong;
		ResponseEntity<Song> response = template.exchange(url, HttpMethod.DELETE, null, new ParameterizedTypeReference<Song>() {});
		
		return response;
		
	}
	
	public ResponseEntity<Song> queryDeleteAllSongs() {
		String url = Util.urlWebapi() + "/deleteallsongs";
		ResponseEntity<Song> response = template.exchange(url, HttpMethod.DELETE, null, new ParameterizedTypeReference<Song>() {});
		
		return response;
		
	}

	/*
	 *  - - - -       - - - -
	- - - - - - EXTRA - - - - - -
	 *  - - - -       - - - -
	*/
	
	public List<SongDetails> defaultSongDetail(){
		List<SongDetails> songDetails = new ArrayList<SongDetails>();
		songDetails.add(Util.defaultSongDetails());
		return songDetails;
		
	}
}
