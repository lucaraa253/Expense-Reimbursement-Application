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
	<h1>Hello and welcome to jsp</h1>
	<%! int num1;
	String guestName;%>
	<%
	guestName = request.getParameter("gname");
	int num2=0;
	for(int i =1; i<=5;i++){
	%>
	<h1>Nicholas Lucara</h1>
	<%
	}
	%>
	
	<h1>Hello</h1>
	<%out.println(num1+num2);%>
	
	<% out.println("Welcome : " + guestName); %>
	<%= "welcome : " + guestName %>
	
</body>
</html>