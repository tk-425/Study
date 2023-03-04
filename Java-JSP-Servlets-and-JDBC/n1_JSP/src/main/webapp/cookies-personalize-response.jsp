<html>
<head>
	<title>Confirmation</title>
</head>
<!-- Read form data and set cookies -->
<%
	// Read form data
	String favLanguage = request.getParameter("favLanguage");

	// Create the cookie
	Cookie cookie = new Cookie("myApp.favLanguage", favLanguage);
	
	// Set the life span
	cookie.setMaxAge(30 * 60);
	
	// Send cookie to browser
	response.addCookie(cookie);
%>
<body>
	Thanks! We set your favorite language to: ${param.favLanguage}
	<br /><br />
	<a href="cookies-homepage.jsp">Return to Home</a>
</body>
</html>