<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
	<c:set var="date" value="<%= LocalDate.now() %>" />
	<c:set var="hour" value="<%= LocalTime.now().getHour() %>" />
	<c:set var="minute" value="<%= LocalTime.now().getMinute() %>" />
	
	Time on the server is ${date} ${hour}:${minute}
</body>
</html>