package com.lab3.aspatharas;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

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
	        try {
	        
	            // loading drivers for mysql
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            
	            //creating connection with the database 
	            Connection con = DriverManager.getConnection
	                        ("jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","12345");
	            
	            PreparedStatement ps = con.prepareStatement
	                        ("insert into accounts values(?,?,?)");
	
	            ps.setString(1, name);
	            ps.setString(2, email);
	            ps.setString(3, password);
	            int i = ps.executeUpdate();
	            
	            
	        	if(i > 0) {
	        		out.println("You are sucessfully registered.");
	            }
	        }
	        catch(Exception se) {
	            se.printStackTrace();
	        }
        }
		else {
			out.println("Passwords need to match.");
        	RequestDispatcher rd = request.getRequestDispatcher("register.html");
        	rd.include(request, response);
		}
	}

}
