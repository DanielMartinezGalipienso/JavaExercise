package example.com.posongclient;

public class Util {
	
	public static String urlWebapi() {
		return "http://localhost:8090/webapi";
	}
	
	public static Score defaultScore() {
		Score score = new Score();
		score.setNameSong("Tear");
		
		return score;
	}
	
	public static SongDetails defaultSongDetails() {
		SongDetails songDetails = new SongDetails();
		songDetails.setDetail("Music");
		songDetails.setValue("cosMo");
		
		return songDetails;
	}
}
