package example.com.posongclient;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private String id;
	private String name;
	private String email;
	private List<Score> scores = new ArrayList<Score>();
	
	
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", email=" + email + ", scores=" + scores + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	

}
