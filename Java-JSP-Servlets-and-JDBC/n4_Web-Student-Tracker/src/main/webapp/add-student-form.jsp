<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Student</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css" />
</head>
<body>
	<jsp:include page="header.jsp" />

	<div id="wrapper">
		<div id="container">
			<h3>Add Student</h3>
			<form action="StudentControllerServlet" method="GET">				
				<table>
					<tbody>
						<tr>
							<td><label>First Name:</label></td>
							<td><input type="text" name="firstName" /></td>
						</tr>
						<tr>
							<td><label>Last Name:</label></td>
							<td><input type="text" name="lastName" /></td>
						</tr>
						<tr>
							<td><label>Email:</label></td>
							<td><input type="text" name="email" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" name="command" value="Save" class="button" /></td>
						</tr>
					</tbody>
				</table>
			</form>

			<p>
				<a href="StudentControllerServlet">Back to List</a>
			</p>
		</div>
	</div>
</body>
</html>