<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
	<% String username = (String)session.getAttribute("username"); %>
	<h2 style="margin: 0 auto; text-align:center;">You are logged in as : <%= username %></h2>
	
	<h1 style="margin: 0 auto; text-align:center;"><a href="managerViewAll.jsp">View all Requests</a></h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="managerViewAllEmployees.jsp">View all Employees</a></h1>
	
	<h1 style="margin: 0 auto; text-align:center;"><a href="index.jsp">Logout</a></h1>
	
	
</body>
</html>