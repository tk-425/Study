<%@ page import="java.util.*" %>
<html>
<head>
	<title>To-Do List</title>
</head>
	<h3>To Do List</h3>
	
	<!-- Step 1: Create HTML Form -->
	<form action="todo-session.jsp">
		Add new item: <input type="text" name="item" />
		<input type="submit" value="Submit" />
	</form>
	
	<!-- Step 2: Add new item to "To Do" list -->
	<%
		// Get the TO DO items from the session
		List<String> items = (List<String>) session.getAttribute("toDoList");

		// If the TO DO items doesn't exist, then create a new one
		if (items == null) {
			items = new ArrayList<>();
			session.setAttribute("toDoList", items);		// Add List object to the session object
		}
		// See if there is form data to add
		String item = request.getParameter("item");
		
		if (item != null) {
			items.add(item);
		}
	%>
	
	<hr>
	<b>To Do List Items:</b><br />
	
	<!-- Step 3: Display all "To Do" items from session -->
	<ol>
		<%
			for (String i: items) {
				out.print("<li>" + i + "</li>");
			}
		%>
	</ol>	
	
	
</html>