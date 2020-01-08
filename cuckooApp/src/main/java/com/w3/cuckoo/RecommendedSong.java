package com.w3.cuckoo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(RecommendedSongId.class)
public class RecommendedSong {
	
	@Id	
	private int recommended_id;
    
	@Id
    private int song_id;
	
	public int getRecommended_id() {
		return recommended_id;
	}

	public void setRecommended_id(int recommended_id) {
		this.recommended_id = recommended_id;
	}

	public int getSong_id() {
		return song_id;
	}

	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
}