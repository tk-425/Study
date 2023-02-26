<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<body>
	<h3>Functions Tag Example</h3>
	<c:set var="data" value="hello world" />
		Length of the string <b>${data}</b>: ${fn:length(data)}
	<br /><br />
	
	Upper-case version of the string <b>${data}</b>: ${fn:toUpperCase(data)}
	<br /><br />
	
	Does the string <b>${data}</b> start with <b>hello</b>? ${fn:startsWith(data, "hello")}	
	
	
	<!-- Split Cities -->
	<c:set var="cityList" value="New York, Seattle, Seoul, Berlin" />

	<c:set var="cities" value="${fn:split(cityList, ',')}" />
	
	<h4>List of Cities</h4>
	<ul>
		<c:forEach var="city" items="${cities}">
			<li>${city}</li>
		</c:forEach>
	</ul>
	<br /><br />
	
	<!-- Join Cities -->
	<h4>Join List of Cities</h4>
	<c:set var="joinCities" value="${fn:join(cities, '*')}" />
	${joinCities}
	
</body>
</html>