package com.servlets.mvc;

import java.util.ArrayList;
import java.util.List;

// Model

public class StudentDataUtil {
	public static List<Student> getStudents() {
		// Create an empty list
		List<Student> students = new ArrayList<>();
		
		// add sample data
		students.add(new Student("Susan", "Owens", "susanowens@mail.com"));
		students.add(new Student("Tim", "Cook", "timcook@mail.com"));
		students.add(new Student("Tiger", "Wood", "tigerwood@mail.com"));
		
		// return the list
		return students;
	}
}
