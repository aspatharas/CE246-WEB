package com.w3.cuckoo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
	
	static EntityManagerFactory factory;
	static EntityManager entityManager;

	public static void main(String[] args) {}
	
	public static void begin() {
		factory = Persistence.createEntityManagerFactory("Unit");
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
	}
	
	//User Class
	public static void createUser(String email,String name,String password) {
		User newUser = new User();
		newUser.setEmail(email);
		newUser.setName(name);
		newUser.setPassword(password);
		entityManager.persist(newUser);
	}
	
	//User Class
	public static User getUser(String email) {
		User user = (User) entityManager.createQuery("FROM User WHERE email= :email").setParameter("email",email).getSingleResult();
		return(user);
	}
	
	//Recommended Class
	public static Recommended getRecommended(String name) {
		Recommended playlist = entityManager.getReference(Recommended.class, name);
		return playlist;
	}
	
	//Recommended Class
	public static List<Recommended> getAllRecommended() {
		@SuppressWarnings("unchecked")
		List<Recommended> playlists = entityManager.createQuery("FROM Recommended").getResultList();
        return playlists;
	}
	
	//Song Class
	public static Song getSong(int song_id) {
		Song song = (Song) entityManager.createQuery("FROM Song WHERE song_id= :id").setParameter("id",song_id).getSingleResult();
        return song;
	}
	
	//Song Class
	public static List<Song> getAllSongs() {
		@SuppressWarnings("unchecked")
		List<Song> songs = entityManager.createQuery("FROM Song").getResultList();
	    return songs;
	}
	
	//Song Class
	public static List<Song> searchSongs(String name) {
		@SuppressWarnings("unchecked")
		List<Song> songs = (List<Song>) entityManager.createQuery("FROM Song WHERE name LIKE '%:name%'").setParameter("name", name).getResultList();
		return  songs;
	}
	
	//Song Class
	public static Song searchSong(String name) {
		Song songs = (Song) entityManager.createQuery("FROM Song WHERE name LIKE :name").setParameter("name", "%"+name+"%").setMaxResults(1).getSingleResult();
		return  songs;
	}
	
	//Playlist Class
	public static void createPlaylist(String name,int user_id) {
		Playlist newPlaylist = new Playlist();
		newPlaylist.setName(name);
		newPlaylist.setUser_id(user_id);
		entityManager.persist(newPlaylist);
	}
	
	//Playlist Class
	public static void deletePlaylist(int playlist_id) {
		Playlist playlist = entityManager.getReference(Playlist.class, playlist_id);
		entityManager.remove(playlist);
	}
	
	//Playlist Class
	public static Playlist getPlaylist(int playlist_id) {		
		Playlist playlist = (Playlist) entityManager.createQuery("FROM Playlist WHERE playlist_id= :id").setParameter("id",playlist_id).getSingleResult();  
        return playlist;
	}
	
	//Playlist Class
	public static List<Playlist> getAllPlaylists(int user_id) {		
		@SuppressWarnings("unchecked")
		List<Playlist> playlists = entityManager.createQuery("FROM Playlist WHERE user_id= :id").setParameter("id",user_id).getResultList();      
        return playlists;
	}
	
	//Artist Class
	public static Artist getArtist(int artist_id) {		
		Artist artist = (Artist) entityManager.createQuery("FROM Artist WHERE artist_id= :id").setParameter("id",artist_id).getSingleResult();      
        return artist;
	}
	
	//RecommendedSong Class
	public static List<Integer> getAllRecommendedSongIds(int recommended_id) {		
		@SuppressWarnings("unchecked")
		List<Integer> song_ids = entityManager.createQuery("SELECT song_id FROM RecommendedSong WHERE recommended_id= :id").setParameter("id", recommended_id).getResultList();     
        return song_ids;
	}
	
	//PlaylistSong Class
	public static void createPlaylistSong(int playlist_id, int song_id) {
		PlaylistSong newPlaylistSong = new PlaylistSong();
		newPlaylistSong.setPlaylist_id(playlist_id);
		newPlaylistSong.setSong_id(song_id);
		entityManager.persist(newPlaylistSong);
	}
	
	//PlaylistSong Class
	public static void deletePlaylistSong(int playlist_id, int song_id) {
		PlaylistSongId PlaylistSong = new PlaylistSongId();
		PlaylistSong.setPlaylist_id(playlist_id);
		PlaylistSong.setSong_id(song_id);
		PlaylistSong playlistSong = entityManager.getReference(PlaylistSong.class, PlaylistSong);
		entityManager.remove(playlistSong);
	}
	
	//PlaylistSong Class
	public static void deleteAllPlaylistSongs(int playlist_id){
		@SuppressWarnings("unchecked")
		List<PlaylistSong> playlistSongs = entityManager.createQuery("FROM PlaylistSong WHERE playlist_id= :id").setParameter("id", playlist_id).getResultList();	
		for (PlaylistSong playlistSong: playlistSongs) {
			deletePlaylistSong(playlistSong.getPlaylist_id(),playlistSong.getSong_id());
		}
	}
	
	//PlaylistSong Class
	public static List<Integer> getAllPlaylistSongIds(int playlist_id) {
		@SuppressWarnings("unchecked")
		List<Integer> song_ids = entityManager.createQuery("SELECT song_id FROM PlaylistSong WHERE playlist_id= :id").setParameter("id", playlist_id).getResultList();  
        return song_ids;
	}
	
	public static void end() {
		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
	}
}
