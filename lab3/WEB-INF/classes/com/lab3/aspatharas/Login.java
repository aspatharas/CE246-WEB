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
        PrintWriter out = response.getWriter();
	
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dbEmail = null;
        String dbPassword = null;
        String dbName = null;
        
        try {
        
            // loading drivers for mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/login?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","12345");
            
            PreparedStatement ps = con.prepareStatement("select * from accounts where email=? and password=?");
            
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
                                    
            while(rs.next()) {
            	dbEmail = rs.getString("email");
            	dbPassword = rs.getString("password");
            	dbName = rs.getString("name");
            }
            
            
            if(email.equals(dbEmail)&&password.equals(dbPassword)) {
            	out.println("Welcome "+ dbName +".");
            }
            else {
            	out.println("Unable to login.");
            	RequestDispatcher rd = request.getRequestDispatcher("index.html");
            	rd.include(request, response);
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	}

}
