package com.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil {
	
	private DataSource dataSource;
	
	private Connection connection = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public StudentDBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Student> getStudents() throws Exception {
		List<Student> studentList = new ArrayList<>();
		
		try {
			// Get connection
			connection = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student order by last_name";
			statement = connection.createStatement();
			
			// execute query & get result
			resultSet = statement.executeQuery(sql);
			
			// process result set
			while (resultSet.next()) {
				
				// retrieve data from result set row
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				
				// create new student object
				Student student = new Student(id, firstName, lastName, email);
				
				// add it to the student list
				studentList.add(student);
			}
			
			return studentList;
			
		} finally {
			// always close the sql resources
			close();
		}
	}

	public void addStundet(Student newStudent) throws Exception {
		try {
			// get database connection
			connection = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into student (first_Name, last_name, email) values (?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			
			// set the parameter values for the student
			preparedStatement.setString(1, newStudent.getFirstName());
			preparedStatement.setString(2, newStudent.getLastName());
			preparedStatement.setString(3, newStudent.getEmail());
			
			// execute query
			preparedStatement.execute();
			
		} finally {
			// clean up JDBC objects
			close();
		}
	}

	public Student getStudent(int id) throws Exception {
		Student student = null;
		
		try {
			// get database connection
			connection = dataSource.getConnection();
			
			// create sql to get selected student & prepared statement
			String sql = "select * from student where id=?";
			preparedStatement = connection.prepareStatement(sql);
			
			// set parameters
			preparedStatement.setInt(1, id);
			
			// execute query
			resultSet = preparedStatement.executeQuery();
			
			// retrieve data from result set
			if (resultSet.next()) {
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String email = resultSet.getString("email");
				
				// use the studentId during construction
				student = new Student(id, firstName, lastName, email);
			} else {
				throw new Exception("Could not find student id: " + id);
			}
			
			return student;
			
		} finally {
			close();
		}		
	}

	public void updateStudent(Student student) throws Exception {
		try {
			// get database connection
			connection = dataSource.getConnection();
			
			// create sql update statement
			String sql = "update student set first_name=?, last_name=?, email=? where id=?";
			
			// prepare statement
			preparedStatement = connection.prepareStatement(sql);
			
			// set parameters
			preparedStatement.setString(1, student.getFirstName());
			preparedStatement.setString(2, student.getLastName());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setInt(4, student.getId());
			
			// execute sql statement
			preparedStatement.execute();
		} finally {
			close();
		}
	}

	public void deleteStudent(int id) throws Exception {
		try {			
			// get database connection
			connection = dataSource.getConnection();
			
			// create sql delete statement
			String sql = "delete from student where id=?";
			
			// prepare statement
			preparedStatement = connection.prepareStatement(sql);
			
			// set parameter
			preparedStatement.setInt(1, id);
			
			// execute sql statement
			preparedStatement.execute();
		} finally {
			close();
		}
	}
	
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			
			if (statement != null) {
				statement.close();
			}
			
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			
			if (connection != null) {
				// doesn't really close it (just puts back in connection pool
				// makes it available for someone else to use
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
