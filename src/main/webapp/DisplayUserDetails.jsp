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
<link type="text/css" rel="stylesheet" href="styles.css">
</head>
<body>
	<%
	String username = (String)session.getAttribute("username");
	UserDAO userDAO = new UserDAOImpl();
	User user = userDAO.getUsersByUsername(username);
	
	%>
	
	<h2>You are logged in as : <%= username %></h2>
	<h1>List of all the users</h1>
	<table border="2" cellspacing="10" cellpadding="10">
	<th>User Id</th><th>UserName</th><th>First Name</th><th>Last Name</th><th>Password</th>
		<tr>
		<td><%= user.getId() %></td>
		<td><%= user.getUsername() %></td>
		<td><%= user.getFirstName() %></td>
		<td><%= user.getLastName() %></td>
		<td><%= user.getPassword() %></td>
		
		</tr>
	
	
	</table>
	<a href="index.jsp">Logout</a>
</body>
</html>