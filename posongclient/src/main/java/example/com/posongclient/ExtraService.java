package example.com.posongclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExtraService {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private SongService songService;
	
	public static Song createSong(String name, ArrayList<String> singers, ArrayList<SongDetails> songDetails) {
		
		Song songCreated = new Song();

		songCreated.setName(name);
		songCreated.setSingers(singers);
		songCreated.setInfo(songDetails);
		
		return songCreated;
		
	}
	
	public static Player createPlayer(String name, String email, List<Score> scores) {
		
		Player playerCreated = new Player();
		
		playerCreated.setName(name);
		playerCreated.setEmail(email);
		playerCreated.setScores(scores);
		
		return playerCreated;
		
	}
	
	public static Score createScore(String nameSong, int timesPlayed, int easy, int normal, int hard, int extreme) {
		
		Score scoreCreated = new Score();
		
		scoreCreated.setNameSong(nameSong);
		scoreCreated.setTimesPlayed(timesPlayed);
		scoreCreated.setScoreForDifficultyA(easy);
		scoreCreated.setScoreForDifficultyB(normal);
		scoreCreated.setScoreForDifficultyC(hard);
		scoreCreated.setScoreForDifficultyD(extreme);
		
		return scoreCreated;
		
	}
	
	public void resetDBPlayers() {
		
		//Delete all Players
		//playerService.queryDeleteAllPlayers();
		
		//Player 1
		//String id = "60be1edaa742a5572df8c60b";
		String name = "Antonio";
		String email = "antoniog07@hotmail.com";
		Score score01 = ExtraService.createScore("World is Mine", 39, 0, 30700, 25010, 10050);
		Score score02 = ExtraService.createScore("METEOR", 10, 0, 0, 17500, 0);
		Score score03 = ExtraService.createScore("Somehow", 16, 0, 0, 19760, 0);
		Score score04 = ExtraService.createScore("shiningray", 7, 0, 0, 26700, 0);
		Score score05 = ExtraService.createScore("Teo", 18, 0, 0, 19700, 39390);
		Score score06 = ExtraService.createScore("Tear", 5, 0, 0, 15800, 0);
		Score score07 = ExtraService.createScore("Ievan Polkka", 13, 0, 19700, 0, 1980);
		Score score08 = ExtraService.createScore("Kokoro", 9, 0, 0, 0, 21600);
		Score score09 = ExtraService.createScore("Migikata no Chou", 11, 0, 19700, 0, 13570);
		Score score10 = ExtraService.createScore("RIP=RELEASE", 9, 0, 0, 0, 36720);
		Score score11 = ExtraService.createScore("Monochrome∞Blue Sky", 11, 0, 0, 39850, 0);
		Score score12 = ExtraService.createScore("World's End Dance Hall", 9, 25010, 0, 28530, 0);
		Score score13 = ExtraService.createScore("Bad ∞ End ∞ Night", 98, 0, 0, 0, 0);
		Score score14 = ExtraService.createScore("The Intense Voice of Hatsune Miku", 19, 0, 0, 39390, 0);
		Score score15 = ExtraService.createScore("Cantarella", 14, 0, 19700, 54520, 0);
		Score score16 = ExtraService.createScore("Nostalogic", 6, 0, 54520, 38420, 0);
		Score score17 = ExtraService.createScore("WAVE", 8, 0, 0, 4980, 46820);
		Score score18 = ExtraService.createScore("Matryoshka", 30, 0, 79510, 3680, 9760);
		Score score19 = ExtraService.createScore("magnet", 12, 0, 0, 19850, 29750);
		Score score20 = ExtraService.createScore("The Disappearance of Hatsune Miku -DEAD END-", 29, 39390, 57850, 31200, 16720);
		List<Score> scores = new ArrayList<Score>();
		scores.add(score15); scores.add(score05); scores.add(score07); scores.add(score13); scores.add(score11);
		
		Player player1 = ExtraService.createPlayer(name, email, scores);
		
		
		playerService.queryAddOnePLayer(player1);
		
		//Player 2
		name = "Miguel";
		email = "juanmiguel72@hotmail.com";
		scores = new ArrayList<Score>();
		scores.add(score07); scores.add(score03); scores.add(score17); scores.add(score09); scores.add(score20);
		
		playerService.queryAddOnePLayer(ExtraService.createPlayer(name, email, scores));
		
		//Player 3
		name = "Carmen";
		email = "carmenortega@gmail.com";
		scores = new ArrayList<Score>();
		scores.add(score18); scores.add(score10); scores.add(score12); scores.add(score09); scores.add(score20);
		
		playerService.queryAddOnePLayer(ExtraService.createPlayer(name, email, scores));
		
		//Player 4
		name = "Cristina";
		email = "cmoya79@gmail.com";
		scores = new ArrayList<Score>();
		scores.add(score19); scores.add(score06); scores.add(score04); scores.add(score16); scores.add(score01);
		
		playerService.queryAddOnePLayer(ExtraService.createPlayer(name, email, scores));
		
		//Player 5
		name = "Jesus";
		email = "mjesus_79@gmail.com";
		scores = new ArrayList<Score>();
		scores.add(score02); scores.add(score10); scores.add(score14); scores.add(score08); scores.add(score20);
		
		playerService.queryAddOnePLayer(ExtraService.createPlayer(name, email, scores));
		
	}
	
	public void resetDBSong() {
		
		//SongsDetails - Annotation
		//1- music 2- lyrics 3- illustration 4- tuning 5- cover 6- producer 7- video
		
		//Delete all Songs
		songService.queryDeleteAllSongs();
		
		//Song 01
		String name = "World is Mine";
		ArrayList<String> singers = new ArrayList<String>();
		SongDetails info1 = new SongDetails(); SongDetails info2 = new SongDetails(); SongDetails info3 = new SongDetails();
		ArrayList<SongDetails> details = new ArrayList<SongDetails>();
		
		singers.add("Hatsune Miku");
		info1.setDetail("music"); info2.setDetail("lyrics"); info3.setDetail("illustration");
		info1.setValue("ryo"); info2.setValue("ryo"); info3.setValue("redjuice");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));
				
		//Song 02
		name = "METEOR";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku");
		SongDetails info4 = new SongDetails(); info4.setDetail("tuning");
		info1.setValue("DIVELA"); info2.setValue("DIVELA"); info3.setValue("Yttrium"); info4.setValue("DIVELA");
		details.add(info1); details.add(info2); details.add(info3); details.add(info4);

		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 03
		name = "Somehow";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("GUMI");
		info1.setValue("Chouchou-P"); info2.setValue("Chouchou-P"); info3.setValue("24");
		details.add(info1); details.add(info2); details.add(info3);

		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));
		
		//Song 04
		name = "shiningray";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku");
		info1.setValue("164"); info2.setValue("164");
		details.add(info1); details.add(info2);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));
		
		//Song 05
		name = "Teo";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku");
		info1.setValue("Omoi"); info2.setValue("Omoi");
		details.add(info1); details.add(info2);

		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 06
		name = "Tear";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku"); singers.add("Kagamine Rin");
		info1.setValue("AVTechNO"); info2.setValue("AVTechNO"); info3.setValue("Kokoa");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 07
		name = "Ievan Polkka";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku");
		SongDetails info5 = new SongDetails(); info5.setDetail("tuning");
		info5.setValue("Otomania"); info3.setValue("Tamago");
		details.add(info5);details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 08
		name = "Kokoro";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku"); singers.add("Kagamine Rin");
		SongDetails info6 = new SongDetails(); info6.setDetail("producer");
		info6.setValue("Toraboruta-P");
		details.add(info6);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 09
		name = "Migikata no Chou";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Kagamine Rin"); singers.add("Kagamine Len");
		info1.setValue("Nori-P"); info2.setValue("Yura Mizuno"); info3.setValue("Akiakane");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));
		//Song 10
		name = "RIP=RELEASE";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Megurine Luka");
		info1.setValue("minato"); info2.setValue("minato"); info3.setValue("Shiina");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 11
		name = "Monochrome∞Blue Sky";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku");
		SongDetails info7 = new SongDetails();
		info1.setValue("Noboru↑-P"); info2.setValue("Noboru↑-P"); info7.setValue("Nidy-2D-");
		details.add(info1); details.add(info2); details.add(info7);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 12
		name = "World's End Dance Hall";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku"); singers.add("Megurine Luka");
		info1.setValue("wowaka"); info2.setValue("wowaka"); info3.setValue("wowaka"); info7.setValue(name);
		details.add(info1); details.add(info2); details.add(info3); details.add(info7);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));
		
		//Song 13
		name = "Bad ∞ End ∞ Night";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku"); singers.add(" Kagamine Rin"); singers.add(" Kagamine Len"); singers.add("Camui Gackpo"); singers.add("GUMI"); singers.add(" MEIKO"); singers.add("KAITO"); singers.add("Megurine Luka");
		SongDetails info8 = new SongDetails();
		info1.setValue("Hitoshizuku-P"); info2.setValue("Hitoshizuku-P"); info3.setValue("Suzunosuke"); info8.setValue("Yama△");;
		details.add(info1); details.add(info2); details.add(info3);

		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 14
		name = "The Intense Voice of Hatsune Miku";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku");
		info1.setValue("cosMo"); info2.setValue("GAiA"); info3.setValue("Hidari");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 15
		name = "Cantarella";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("KAITO"); singers.add("Hatsune Miku");
		info1.setValue("Kurousa-P"); info2.setValue("Kurousa-P"); info3.setValue("exray, Terada, Bear, SYURI999, Fubuki, Um, kiri");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 16
		name = "Nostalogic";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("MEIKO");
		info1.setValue("yuukiss"); info2.setValue("yuukiss"); info3.setValue("rose");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 17
		name = "WAVE";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Lily");
		info6.setValue("niki");
		details.add(info6);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 18
		name = "Matryoshka";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku"); singers.add("GUMI");
		info1.setValue("Hachi"); info2.setValue("Hachi"); info3.setValue("Hachi"); info7.setValue("Hachi");
		details.add(info1); details.add(info2); details.add(info3); details.add(info7);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 19
		name = "magnet";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku"); singers.add("Megurine Luka");
		info1.setValue("minato"); info2.setValue("minato"); info3.setValue("Yunomi-P");
		details.add(info1); details.add(info2); details.add(info3);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));

		//Song 20
		name = "The Disappearance of Hatsune Miku -DEAD END-";
		singers = new ArrayList<String>();
		details = new ArrayList<SongDetails>();
		singers.add("Hatsune Miku");
		info6.setValue("cosMo");
		details.add(info6);
		
		songService.queryAddOneSong(ExtraService.createSong(name, singers, details));
		

		//SongsDetails - Annotation
		//1- music 2- lyrics 3- illustration 4- tuning 5- cover 6- producer 7- video
		
	}
}
