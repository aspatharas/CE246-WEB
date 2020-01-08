package com.w3.cuckoo;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");             
        

        Manager.begin();
        
        User user = Manager.getUser(email);
        List<Song> allSongs = Manager.getAllSongs();
        List<Recommended> recommended = Manager.getAllRecommended();
        List<Playlist> playlists = Manager.getAllPlaylists(user.getUser_id());
            
        if(user != null && password.equals(user.getPassword())) {
        	request.getSession().setAttribute("user", user);
        	request.getSession().setAttribute("allSongs", allSongs);
        	request.getSession().setAttribute("recommended",recommended);
        	request.getSession().setAttribute("playlists",playlists);
        	response.sendRedirect("home.jsp");
        }
        else {
        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=white>Unable to login.</font>");
			rd.include(request, response);
        	
        } 
        
        Manager.end();
    }
}
