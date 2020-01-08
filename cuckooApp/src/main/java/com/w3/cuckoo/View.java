package com.w3.cuckoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class View
 */
@WebServlet("/View")
public class View extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public View() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
               
        Manager.begin();
        
        String op = request.getParameter("operation");
        int playlist_id = (int) request.getSession().getAttribute("playlist_id");
        if(op.equals("create")) {
        	try {
	        	String name = request.getParameter("song_name");
	        	Song song = Manager.searchSong(name);
	        	Manager.createPlaylistSong(playlist_id, song.getSong_id());
        	}
        	catch(NoResultException nre) {}
        }
        else {
        	int song_id = Integer.parseInt(op);
        	Manager.deletePlaylistSong(playlist_id, song_id);
        }
        
        List<Integer> song_ids = Manager.getAllPlaylistSongIds(playlist_id);
        List<Song> songs = new ArrayList<Song>();
        List<Artist> artists = new ArrayList<Artist>();
        
        for(int id : song_ids) {
        	Song song = Manager.getSong(id);
        	songs.add(song);
        	artists.add(Manager.getArtist(song.getArtist_id()));
        }
        
        request.getSession().setAttribute("playlist_songs", songs);
        request.getSession().setAttribute("artists", artists);
        response.sendRedirect("libraryView.jsp");
        
        Manager.end();
    }
}
