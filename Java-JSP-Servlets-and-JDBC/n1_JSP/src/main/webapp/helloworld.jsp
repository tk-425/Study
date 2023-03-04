<%@page import="java.util.Date"%>
<html>
<body>
	<h3>Hello World!</h3>
	The time on the server is
	<%=new Date()%>

	Converting a string to upper case:
	<%=new String("hello world").toUpperCase()%>
	<br>
	<br> 25 * 4 =
	<%=25 * 5%>
	<br>
	<br> 
	75 &lt; 69 ?
	<%=75 < 69%>
</body>
</html>