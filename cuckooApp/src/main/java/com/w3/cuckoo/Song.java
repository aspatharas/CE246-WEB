package com.w3.cuckoo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int song_id;
	private String name;
	private int length;
	private int artist_id;

	
	public int getSong_id() {
		return song_id;
	}
	
	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}

	public int getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	
	/*public int getArtist_id() {
		return artist_id;
	}
	
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	
	public List<PlaylistSong> getPlaylists() {
		return playlists;
	}
	
	public List<RecommendedSong> getRecommendedLists() {
		return recommended;
	}*/
}
