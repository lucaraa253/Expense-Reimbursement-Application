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
	
	<% String username = (String)session.getAttribute("username"); %>
	<% String searchname = request.getParameter("searchname"); %>
	
	<%
	UserDAO userDAO = new UserDAOImpl();
	List<User> users = userDAO.getUsersByUsername(searchname);
	Iterator<User> iterator = users.iterator();
	%>
	
	<h2>You are logged in as : <%= username %></h2>
	<h1>List of all the users</h1>
	<table border="2" cellspacing="10" cellpadding="10">
	<th>User Id</th><th>UserName</th><th>Password</th><th>Gender</th><th>Notifications</th><th>Qualifications</th>
	
	
	<% while(iterator.hasNext()){
		
		User user = iterator.next();
		
		%>
		<tr><td><%= user.getUserId() %></td>
		<td><%= user.getUsername() %></td>
		<td><%= user.getPassword() %></td>
		<td><%= user.getGender() %></td>
		<td><%= user.getNotifications() %></td>
		<td><%= user.getQualifications() %></td>
		</tr>
	<%} %>
	
	</table>
	<a href="index.jsp">Logout</a>
</body>
</html>