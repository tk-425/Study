<html>
<body>
	<jsp:include page="header.html" />
	
	<div align="center">
		<% 
			for (int i = 0; i < 10; i++) {
				out.print("Hello World!<br />");
			}
		%>	
	</div>
	
	<jsp:include page="footer.jsp" />
</body>
</html>