<%@page import="java.util.Iterator"%>
<%@page import="com.training.ers.models.Request"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.RequestDAOImpl"%>
<%@page import="com.training.ers.dao.RequestDAO"%>

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
	
	
	RequestDAO requestDAO = new RequestDAOImpl();
	List<Request> allRequests = requestDAO.managerViewAll();
	Iterator<Request> iterator = allRequests.iterator();
	%>
	
	
	<h1>List of all the users</h1>
	<table border="2" cellspacing="10" cellpadding="10">
	<th>Request ID</th><th>Description</th><th>Ammount</th><th>Approved?</th>
	<% while(iterator.hasNext()){
		
		Request req = iterator.next();
		
		%>
		<tr>
		
		<td><%= req.getId() %></td>
		<td><%= req.getDescription() %></td>
		<td><%= req.getAmount() %></td>
		<td><%= req.isApproved() ? "Yes" : "No" %></td>
	<%-- 	<td><%= request.get() %></td> --%>
		
		</tr>
	<%} %>
	
	</table>
</body>
</html>