<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%-- <%
		// get the students from the request object (sent by servlet)
		List<Student> students = (List<Student>) request.getAttribute("STUDENT_LIST");
%> --%>

<table>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Action</th>
	</tr>

	<!-- JSTL -->	
	<c:forEach var="student" items="${STUDENT_LIST}">
		<!-- Set up a link for update student -->
		<!-- This will add parameters for command and studentID at the end of the URL -->
		<!-- example:
				http://localhost:8080/project-name/servletName?command=Load&studentId=4   
		-->
		<c:url var="updateLink" value="StudentControllerServlet">
			<!-- Create a command for Load -->
			<c:param name="command" value="Load" />
			<!-- Create a parameter for the student id -->
			<c:param name="studentId" value="${student.id}" />
		</c:url>
		
		<!-- Set up a link for delete student -->
		<c:url var="deleteLink" value="StudentControllerServlet">
			<!-- Create a command for Delete -->
			<c:param name="command" value="Delete" />
			<!-- Create a parameter for the student id -->
			<c:param name="studentId" value="${student.id}" />
		</c:url>
		
		<tr>
			<td>${student.firstName}</td>
			<td>${student.lastName}</td>
			<td>${student.email}</td>
			<td>
				<a href="${updateLink}">Update</a> 
				|
				<a href="${deleteLink}" onclick="if (! (confirm('Are you sure you want to delete this student?'))) return false">
					Delete								<!-- JavaScript Code -->
				</a>
			</td>
		</tr>
	</c:forEach>

	<!-- JSP -->
<%-- <% for (Student student : students) { %>
		<tr>
			<td> <%= student.getFirstName() %> </td>
			<td> <%= student.getLastName() %> </td>
			<td> <%= student.getEmail() %> </td>
		</tr>
	<% } %> --%>

</table>
