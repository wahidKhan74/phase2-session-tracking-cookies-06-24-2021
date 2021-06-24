package com.dell.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/profile")
public class Profile extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public Profile() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//verify user from cookies
		Cookie[] cks = request.getCookies();
		if(cks!=null) {
			String email = cks[0].getValue();
			if(email.equals("admin@gmail.com")) {
				// nav bar
				request.getRequestDispatcher("index.html").include(request, response);
				out.println("<h3 style='color:green'> Welcome to user profile '"+email+"' </h3>");
			}
			
		} else {
			// nav bar
			request.getRequestDispatcher("index.html").include(request, response);
			
			out.println("<h3 style='color:red'>Invalid access, please login to see profile ! </h3>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
