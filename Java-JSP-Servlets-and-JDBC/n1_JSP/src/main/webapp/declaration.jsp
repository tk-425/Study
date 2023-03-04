<html>
<body>
	<h3>JSP Declaration</h3>
	<%!
		String makeItLowerCase(String data) {
			return data.toLowerCase();
		}
	%>
	
	Lower case "HELLO WORLD": <%= makeItLowerCase("HELLO WORLD") %>
</body>
</html>