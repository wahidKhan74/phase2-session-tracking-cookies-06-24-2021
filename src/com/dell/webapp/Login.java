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
 * Servlet implementation class Register
 */
@WebServlet("/login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.sendRedirect("login.html");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userEmail = request.getParameter("useremail");
		String password = request.getParameter("password");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");

		if (userEmail != null && password != null && !userEmail.equals("") && !password.equals("")) {
			if (userEmail.equals("admin@gmail.com") && password.equals("admin@123")) {
				// session tracking based on cookies
				// create cookie
				Cookie ck = new Cookie("xemail", userEmail);
				// add cookie in response
				response.addCookie(ck);
				// nav bar
				request.getRequestDispatcher("index.html").include(request, response);
				out.println("<h3 style='color:green'>Login sucessfull ! for user '" + userEmail + "' </h3>");

			} else {
				// nav bar
				request.getRequestDispatcher("index.html").include(request, response);
				out.println("<h3 style='color:red'>Login Failed * Invalid credntials </h3>");
			}
		} else {
			// nav bar
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("<h3 style='color:red'>Login Failed  * Required filled are missing! </h3>");
		}
	}

}
