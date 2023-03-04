package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: Content Type
		 response.setContentType("text/html");
		 
		// Step 2: PrintWriter
		PrintWriter out = response.getWriter();
		
		// Step 3: Generate HTML Content
		 out.print("<html><body>");
		 
		 out.print("The student is confirmed: "
			 + request.getParameter("firstName")
			 + request.getParameter("lastName")
		 );
		 
		 out.print("</html></body>");
	}

}
