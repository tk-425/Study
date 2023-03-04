package com.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	
	// Define dataSource/connection pool for Resource Injection
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// #1 - Set up the ContextType & PrintWriter
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		// #2 - Get a connection to the database
		try {
			// #3 - Get connection pool
			connection = dataSource.getConnection();
			
			// #4 - Create a SQL statements
			String sql = "select * from student";
			statement = connection.createStatement();
			
			// #5 - Execute SQL query
			resultSet = statement.executeQuery(sql);
			
			// #6 - Process the result set
			while (resultSet.next()) {
				out.println(resultSet.getString("email"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
