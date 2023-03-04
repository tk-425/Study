<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.*, com.n2_TagDemo.tag.Customer"%>

<%
// Just create some sample data (normally provided by MVC system)
List<Customer> data = new ArrayList<>();
data.add(new Customer("John", "Doe", false));
data.add(new Customer("Maxwell", "Johnson", false));
data.add(new Customer("Mary", "Owens", true));

pageContext.setAttribute("customerData", data);
%>

<html>
<head>
<title>Customer Information</title>
</head>
<body>
	<h3>Customer Information</h3>

	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Special Discount</th>
		</tr>
		<c:forEach var="customer" items="${customerData}">
			<!-- JSP will call customer.getFirstName() method  -->
			<tr>
				<td>${customer.firstName}</td> 
				<td>${customer.lastName}</td>
				<td>
					<c:if test="${customer.goldCustomer}">					
						Available
					</c:if>
					
					<c:if test="${not customer.goldCustomer}">					
						N/A
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>