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
	<h2>You are logged in as : <%= username %></h2>
	<h3>Yessir</h3>
	<h1><a href="displayRequests.jsp">View all Requests</a></h1>
	<h1><a href="submitRequest.html">Submit Request</a></h1>
	<h1><a href="DisplayUserDetails.jsp">My Information</a></h1>
	<h1><a href="index.jsp">Log out</a></h1>
	
</body>
</html>