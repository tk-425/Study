package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ContextParamServlet")
public class ContextParamServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: Content Type
		response.setContentType("text/html");
	
		// Step 2: PrintWriter
		PrintWriter out = response.getWriter();
		
		// Step 3: Read Configuration parameters
		ServletContext context = getServletContext();
		
		String maxCart = context.getInitParameter("max-shopping-cart-size");
		String teamName = context.getInitParameter("project-team-name");
		
		// Step 4: Generate HTML Content
		out.print("<html><body>");
		
		out.print("Max Shopping cart size: " + maxCart + "<br />");
		out.print("Project team name: " + teamName);
		
		out.print("</html></body>");
	}
}
