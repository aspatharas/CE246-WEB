package w3.aspatharas.webApp;

import java.io.IOException;

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
			AccountsManager.begin();
	        if(AccountsManager.read(email)!=null) {
	        	out.println("There is already an account with this email.");
	        }
	        else {
	        	AccountsManager.create(email, name, password);
	        	out.println("You are successfully registered.");
	        }
	        AccountsManager.end();
        }
		else {
			out.println("Passwords need to match.");
        	RequestDispatcher rd = request.getRequestDispatcher("register.html");
        	rd.include(request, response);
		}
	}

}
