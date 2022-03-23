<%@page import="java.util.Iterator"%>
<%@page import="com.training.ers.models.User"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.UserDAOImpl"%>
<%@page import="com.training.ers.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%
	UserDAO userDAO = new UserDAOImpl();
	List<User> allUsers = userDAO.getUsers();
	Iterator<User> iterator = allUsers.iterator();
	%>
	<h1 style="margin: 0 auto; text-align:center;">All Employees</h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="welcome.jsp">Home Page</a></h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="managerViewAll.jsp">View all Requests</a></h1>
	
	<h1 style="margin: 0 auto; text-align:center;"><a href="index.jsp">Logout</a></h1>
	<table border="2" cellspacing="10" cellpadding="10" class="table table-striped">
	<th>ID</th><th>Username</th><th>First Name</th><th>Last Name</th><th>See Details</th><th>View All Requests</th>
	<% while(iterator.hasNext()){
		
		User user = iterator.next();
		
		%>
		<tr>
		<td><%= user.getId() %></td>
		<td><%= user.getUsername() %></td>
		<td><%= user.getFirstName() %></td>
		<td><%= user.getLastName() %></td>
		<td><form action="EmployeeShowRequest"><input type="hidden" value="<%= user.getUsername() %>" name="username"></input><input type="submit" value="See Details"></input></form></td>
		<td><form action="ShowEmployeeRequests"><input type="hidden" value="<%= user.getUsername() %>" name="uname"></input><input type="submit" value="Show Employee Requests"></input></form></td>
		</tr>
	<%} %>
	
	</table>
	

</body>
</html>