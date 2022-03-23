<%@page import="java.util.Iterator"%>
<%@page import="com.training.ers.models.Request"%>
<%@page import="java.util.List"%>
<%@page import="com.training.ers.dao.RequestDAOImpl"%>
<%@page import="com.training.ers.dao.RequestDAO"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
	
	
	
	<h1 style="margin: 0 auto; text-align:center;">All of my requests</h1>
	<h3 style="margin: 0 auto; text-align:center;"><a href="welcomeEmployee.jsp">Home Page</a></h3>
	<h3 style="margin: 0 auto; text-align:center;"><a href="DisplayUserDetails.jsp">My Information</a></h3>
	<h3 style="margin: 0 auto; text-align:center;"><a href="submitRequest.html">Submit Request</a></h3>
	<h3 style="margin: 0 auto; text-align:center;"><a href="index.jsp">Log out</a></h3>
	
	
	<table border="2" cellspacing="10" cellpadding="10" class="table table-striped">
	<th>Request ID</th><th>Description</th><th>Ammount</th><th>Approved?</th><th>See all Details</th><th>Edit Details</th>
	<% while(iterator.hasNext()){
		
		Request req = iterator.next();
		
		%>
		<tr>
		
		<td><%= req.getId() %></td>
		<td><%= req.getDescription() %></td>
		<td><%= req.getAmount() %></td>
		<td><%= req.isApproved() ? "Yes" : "No" %></td>
		<td><form action="ShowRequest"><input type="hidden" value="<%= req.getId() %>" name="id"></input><input type="submit" value="See Details"></input></form></td>
		<td><form action="EditRequestController"><input type="hidden" value="<%= req.getId() %>" name="id"></input><input type="submit" value="Edit Request"></input></form></td>
		<td><form action="DeleteRequest2Controller"><input type="hidden" value="<%= req.getId() %>" name="id"></input><input type="submit" value="Delete Request"></input></form></td>
	<%-- 	<td><%= request.get() %></td> --%>
		
		</tr>
	<%} %>
	
	</table>
</body>
</html>