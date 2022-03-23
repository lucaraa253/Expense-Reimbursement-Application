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
	String username = (String)session.getAttribute("username");
	UserDAO userDAO = new UserDAOImpl();
	User user = userDAO.getUsersByUsername(username);
	
	%>
	<h1 style="margin: 0 auto; text-align:center;">My Details</h1>
	<h3 style="margin: 0 auto; text-align:center;"><a href="welcomeEmployee.jsp">Home Page</a></h3>
	<h3 style="margin: 0 auto; text-align:center;"><a href="displayRequests.jsp">View all Requests</a></h3>
	<h3 style="margin: 0 auto; text-align:center;"><a href="submitRequest.html">Submit Request</a></h3>
	<h3 style="margin: 0 auto; text-align:center;"><a href="index.jsp">Log out</a></h3>
	
	<table border="2" cellspacing="10" cellpadding="10" class="table table-striped">
	<th>User Id</th><th>UserName</th><th>First Name</th><th>Last Name</th><th>Password</th>
		<tr>
		<td><%= user.getId() %></td>
		<td><%= user.getUsername() %></td>
		<td><%= user.getFirstName() %></td>
		<td><%= user.getLastName() %></td>
		<td><%= user.getPassword() %></td>
		
		</tr>
	
	
	</table>
</body>
</html>