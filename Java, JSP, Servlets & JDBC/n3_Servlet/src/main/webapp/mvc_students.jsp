<!-- View -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
	<h3>Student Table</h3>
	<hr />
	
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="student" items="${studentList}">
			<tr>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
			</tr>
		</c:forEach>
	</table>
	
	<button onclick="history.back()" style="margin-block: 1rem">Go Back</button>
	
</body>
</html>