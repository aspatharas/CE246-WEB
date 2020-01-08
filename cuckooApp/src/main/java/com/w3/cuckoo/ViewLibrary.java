package com.w3.cuckoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewLibrary
 */
@WebServlet("/ViewLibrary")
public class ViewLibrary extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewLibrary() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		Manager.begin();
        
        int playlist_id = Integer.parseInt(request.getParameter("viewBtn"));
        List<Integer> song_ids = Manager.getAllPlaylistSongIds(playlist_id);
        
        List<Song> songs = new ArrayList<Song>();
        List<Artist> artists = new ArrayList<Artist>();
        
        for(int song_id : song_ids) {
        	Song song = Manager.getSong(song_id);
        	songs.add(song);
        	artists.add(Manager.getArtist(song.getArtist_id()));
        }
        
        request.getSession().setAttribute("playlist_id", playlist_id);
        request.getSession().setAttribute("playlist_songs", songs);
        request.getSession().setAttribute("artists", artists);
        response.sendRedirect("libraryView.jsp");
        
        Manager.end();
    }
}
