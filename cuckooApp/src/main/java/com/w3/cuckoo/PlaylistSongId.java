package com.w3.cuckoo;

import java.io.Serializable;

public class PlaylistSongId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	protected int playlist_id;
    protected int song_id;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + playlist_id;
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
        PlaylistSongId other = (PlaylistSongId) obj;
        if (playlist_id == -1) {
            if (other.playlist_id != -1)
                return false;
        } else if (playlist_id!=other.playlist_id)
            return false;
        if (song_id == -1) {
            if (other.song_id != -1)
                return false;
        } else if (song_id!=other.song_id)
            return false;
        return true;
    }

	public int getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(int playlist_id) {
		this.playlist_id = playlist_id;
	}

	public int getSong_id() {
		return song_id;
	}

	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
}