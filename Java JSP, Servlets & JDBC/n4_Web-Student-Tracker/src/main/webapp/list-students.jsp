<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*, com.web.jdbc.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Student Tracker App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div id="container">
		<div id="content">
			<!-- Put new button: Add Student -->
			<input 
				type="submit" 
				value="Add Student" 
				onclick="window.location.href='add-student-form.jsp'; return false;" 
				class="add-student-button"
			/>
		
			<jsp:include page="student-table.jsp" />
		</div>
	</div>
</body>
</html>