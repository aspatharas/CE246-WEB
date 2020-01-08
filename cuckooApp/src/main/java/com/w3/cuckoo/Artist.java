package com.w3.cuckoo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int artist_id;
	private String name;
	
	public int getArtsist_id() {
		return artist_id;
	}
	
	public void setArtsist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}