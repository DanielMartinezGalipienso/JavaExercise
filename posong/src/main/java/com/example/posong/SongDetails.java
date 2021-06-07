package com.example.posong;

public class SongDetails {
	
	private String detail;
	private String value;
	
	
	
	@Override
	public String toString() {
		return "SongDetails [detail=" + detail + ", value=" + value + "]";
	}
	
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
