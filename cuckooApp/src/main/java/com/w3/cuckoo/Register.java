package com.w3.cuckoo;

import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password_repeat = request.getParameter("password-repeat");
        
                
		if(password.equals(password_repeat)) {
			Manager.begin();
	        try {
	        	Manager.getUser(email);
	        	RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
	        	out.println("There is already an account with this email.");
	        	rd.include(request, response);
	        	Manager.end();
	        }
	        catch(NoResultException nre) {
	        	Manager.createUser(email, name, password);
	        	out.println("You are successfully registered.");
	        	RequestDispatcher rd = request.getRequestDispatcher("/login.html");
	        	rd.include(request, response);
	        	Manager.end();
	        }   
        }
		else {
			out.println("Passwords need to match.");
        	RequestDispatcher rd = request.getRequestDispatcher("/register.html");
        	rd.include(request, response);
		}
	}

}
