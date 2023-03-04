<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
	<h3>Student List</h3>
	
	<ul>
		<c:forEach var="student" items="${studentList}">
			<li>${student}</li>
		</c:forEach>
	</ul>
</body>
</html>