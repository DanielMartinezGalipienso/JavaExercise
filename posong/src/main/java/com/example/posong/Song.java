package com.example.posong;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "song")
public class Song {
	
	@Id
	private String id;
	private String name;
	private List<String> singers;
	private List<SongDetails> info;
	
	
	
	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", singers=" + singers + ", info=" + info + "]";
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
	
	public List<String> getSingers() {
		return singers;
	}

	public void setSingers(List<String> singers) {
		this.singers = singers;
	}

	public List<SongDetails> getInfo() {
		return info;
	}
	public void setInfo(List<SongDetails> info) {
		this.info = info;
	}
	
	
	
}
