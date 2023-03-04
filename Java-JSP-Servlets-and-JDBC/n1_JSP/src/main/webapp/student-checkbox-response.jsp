<html>
<head>
	<title>Student Confirmation</title>
</head>
<body>
	<h3>Student Confirmation</h3>
	The student is confirmed: ${param.firstName} ${param.lastName}
	<br /><br />
	Favorite Programming Languages:
	<%
		String[] langs = request.getParameterValues("favLanguages");
	
		for (String lang : langs) {
			out.print("<li>" + lang + "</li>");
		}
	%>
</body>
</html>