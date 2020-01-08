package com.w3.cuckoo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Library
 */
@WebServlet("/Library")
public class Library extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Library() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
               
        Manager.begin();
        
        String op = request.getParameter("operation");
        User user = (User) request.getSession().getAttribute("user");
        if(op.equals("create")) {
        	String name = request.getParameter("playlist_name");
        	Manager.createPlaylist(name, user.getUser_id());
        }
        else {
        	int playlist_id = Integer.parseInt(op);
        	Manager.deletePlaylist(playlist_id);
        }
        
        List<Playlist> playlists= (List<Playlist>) Manager.getAllPlaylists(user.getUser_id());
        
        request.getSession().setAttribute("playlists", playlists);
        response.sendRedirect("library.jsp");
        
        Manager.end();
    }
}
