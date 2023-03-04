<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%
	// just create some sample data (normally provided by MVC system)
	String[] cities = {"New York", "Los Angeles", "Chicago"};
	
	// set the data as a page context attribute
	pageContext.setAttribute("myCities", cities);  // name-value pair
%>

<body>
	<h3>Retrieve City Data:</h3>
	<ul>
		<c:forEach var="city" items="${myCities}">
			<li>${city}</li>
		</c:forEach>
	</ul>
</body>
</html>