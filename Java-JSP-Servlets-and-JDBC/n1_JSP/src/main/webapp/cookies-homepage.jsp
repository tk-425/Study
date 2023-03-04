<%@page import="java.time.LocalDate"%>
<html>
<head>
	<title>Training Portal</title>
</head>
<body>
	<h3>Training Portal</h3>
	
	<!-- Read the favorite programming language cookie -->
	<%
		// Set default value (in case there are no cookies)
		String favLanguage = "Java";
	
		// Get the cookies from the browser request
		Cookie[] cookies = request.getCookies();
		
		// Find favorite language cookie
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("myApp.favLanguage".equals(cookie.getName())) {
					favLanguage = cookie.getValue();
					break;
				}
			}
		}
	%>
	
	<!-- Show a personalized page -->
	<h4>New Books for <%= favLanguage %></h4>
	
	<ul>
		<li>New <%= favLanguage %> Guide</li>
		<li>Complete <%= favLanguage %> Training <%= LocalDate.now().getYear() %>, 2nd Edition</li>
	</ul>
	
	<h4>Latest News Report for <%= favLanguage %></h4>
	
	<ul>
		<li><%= favLanguage %> top most wanted list for employers</li>
		<li>Introduction to virtual threads: A new approach to <%= favLanguage %> concurrency</li>
	</ul>
	
	<h4>Hot Jobs for <%= favLanguage %></h4>
	
	<ul>
		<li>Back-end <%= favLanguage %> Programmer</li>
		<li>Full stack <%= favLanguage %> developer</li>
	</ul>
	
	<hr />
	<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>