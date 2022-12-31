<html>
<body>
	<h3>JSP Scriptlets</h3>
	
	<%
		for (int i = 0; i < 5; i ++) {
			out.print("<br />Count: " + i);
		}
	%>
</body>
</html>