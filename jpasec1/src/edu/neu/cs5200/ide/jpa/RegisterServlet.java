package edu.neu.cs5200.ide.jpa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//System.out.println("Hello from login servlet"+ username + " " + password);
		
		// should have a singleton here 
		UserDao dao = new UserDao(); 
		
		if(dao.findUserByName(username) == null) {
			dao.createUser(new User(username, password));
			response.sendRedirect("/jpasec1/login.jsp");
		} else {
			System.out.println("Username not available");
			response.sendRedirect("/jpasec1/register.jsp");
		}
		
		
//		if(user == null) {
//			response.sendRedirect("/jpasec1/login.jsp");
//		} else {
//			// pass user object onto next page
//			request.setAttribute("user", user);
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/DataSet.jsp");
//			dispatcher.forward(request, response);
////			response.sendRedirect("/WeatherApp/listMyWeatherLocations.jsp");
//		}
	}

}
