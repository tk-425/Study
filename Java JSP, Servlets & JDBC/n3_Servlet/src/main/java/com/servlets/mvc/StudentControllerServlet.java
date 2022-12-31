package com.servlets.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Step 1: get the student data from model class
		List<Student> students = StudentDataUtil.getStudents();
		
		// Step 2: add students to request object
		request.setAttribute("studentList", students);
		
		// Step 3: get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mvc_students.jsp");
		
		// Step 4: forward to JSP
		dispatcher.forward(request, response);
	}
}
