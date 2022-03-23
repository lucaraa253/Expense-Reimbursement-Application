<%@page import="com.training.ers.models.User"%>
<%@page import="com.training.ers.dao.UserDAOImpl"%>
<%@page import="com.training.ers.dao.UserDAO"%>
<%@page import="com.training.ers.dao.RequestDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		
	
		String id3 = (String) session.getAttribute("username");
		HttpSession newsession = request.getSession();
		String uname = (String) request.getParameter("username");
		
		UserDAO userDAO = new UserDAOImpl();
		User user = new User();
		user = userDAO.getUsersByUsername(uname);
	
	%>
	<h1><a href="managerViewAll.jsp">View all Requests</a></h1>
	<a href="welcome.jsp">Home page</a>
	<h1><a href="index.jsp">Log out</a></h1>
	<table border="2" cellspacing="10" cellpadding="10" class="table table-striped">
	<tr><th>User Id</th><th>User Name</th><th>FirstName</th><th>Password</th></tr>
		<tr>
		<td><%= user.getId() %></td>
		<td><%= user.getUsername() %></td>
		<td><%= user.getFirstName() %></td>
		<td><%= user.getLastName() %></td>
		</tr>
	</table>
</body>
</html>