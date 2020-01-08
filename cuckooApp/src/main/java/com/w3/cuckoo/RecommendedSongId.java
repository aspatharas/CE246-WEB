package com.w3.cuckoo;

import java.io.Serializable;

public class RecommendedSongId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected int recommended_id;
    protected int song_id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + recommended_id;
        result = prime * result + song_id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RecommendedSongId other = (RecommendedSongId) obj;
        if (recommended_id == -1) {
            if (other.recommended_id != -1)
                return false;
        } else if (recommended_id!=other.recommended_id)
            return false;
        if (song_id == -1) {
            if (other.song_id != -1)
                return false;
        } else if (song_id!=other.song_id)
            return false;
        return true;
    }
}