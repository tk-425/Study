package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MVC_Servlet")
public class MVC_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 0: Add data
		String[] students = {"Susan", "Michael", "Tim", "Jack"};
		request.setAttribute("studentList", students);
		
		// Step 1: Get Request Dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view_students.jsp");
		
		// Step 2: Forward to the JSP
		dispatcher.forward(request, response);
	}

}
