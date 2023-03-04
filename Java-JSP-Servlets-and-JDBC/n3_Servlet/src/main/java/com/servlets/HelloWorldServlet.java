package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloWorldServlet")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: Set the content type
		response.setContentType("text/html");
		
		// Step 2: Get the PrintWriter
		PrintWriter out = response.getWriter();
		
		
		// Step 3: Generate HTML content
		out.print("<html><body>");
		
		out.print("<h3>Hello World</h3>");
		out.print("<hr />");
		out.print("Time on the Server is: " + LocalDate.now() + " " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute());
		
		
		out.print("</html></body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
