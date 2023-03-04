package com.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDBUtil studentDBUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();

		try {
			// initialize dataSource object
			// create instance of studentDBUtil and pass in the connection pool / dataSource object
			studentDBUtil = new StudentDBUtil(dataSource);
		} catch (Exception e) {
			throw new ServletException(e); 
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// read the "command" parameter (name-value pair)
			String command = request.getParameter("command");
			
			// if command is null set as List
			if (command == null) command = "List";
			
			switch (command) {
				case "List":
					listStudents(request, response);
					break;
					
				case "Save":
					addStudent(request, response);
					break;
				
				case "Load":
					loadStudent(request, response);
					break;
					
				case "Update":
					updateStudent(request, response);
					break;
					
				case "Delete":
					deleteStudent(request, response);
					break;
			
				default:
					listStudents(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		int id = stringToInt(request.getParameter("studentId"));
		
		// delete student from database
		studentDBUtil.deleteStudent(id);
		
		// send them back to the "List Student" page
		listStudents(request, response);
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data		
		int id = stringToInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create a new student object so that we can pass to database util class
		Student student = new Student(id, firstName, lastName, email);
		
		// perform update on database
		studentDBUtil.updateStudent(student);
		
		// send them back to the "List Student" page
		listStudents(request, response);
	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student id from form data
		int id = stringToInt(request.getParameter("studentId"));
				
		// get student from database
		Student student = studentDBUtil.getStudent(id);
				
		// place student in the request attribute
		request.setAttribute("THE_STUDENT", student);
		
		// send to JSP page: update-student-form.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		// create a new student object
		Student newStudent = new Student(firstName, lastName, email);
		
		// add the student to the database
		studentDBUtil.addStundet(newStudent);
		
		// send back to main page (the student list)
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// get students from StudentDBUtil class
		List<Student> studentList = studentDBUtil.getStudents();
		
		// add students to the request (name-value pair)
		request.setAttribute("STUDENT_LIST", studentList);
		
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}

	private int stringToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			throw new NumberFormatException();
		}
	}
}
