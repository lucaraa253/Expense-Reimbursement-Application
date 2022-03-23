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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<%
	String uname2 = request.getParameter("uname");
	RequestDAO requestDAO = new RequestDAOImpl();
	List<Request> allRequests = requestDAO.viewAllRequests(uname2);
	Iterator<Request> iterator = allRequests.iterator();
	%>
	
	
	<h1 style="margin: 0 auto; text-align:center;">All users requests</h1>
	
	<h1 style="margin: 0 auto; text-align:center;"><a href="welcome.jsp">Home Page</a></h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="managerViewAll.jsp">All Requests</a></h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="index.jsp">Log out</a></h1>
	<table border="2" cellspacing="10" cellpadding="10" class="table table-striped">
	<th>ID</th><th>Description</th><th>Ammount</th><th>Approved?</th><th>ReqId</th>
	<% while(iterator.hasNext()){
		
		Request req = iterator.next();
		
		%>
		<tr>
		<td><%= req.getId() %></td>
		<td><%= req.getDescription() %></td>
		<td><%= req.getAmount() %></td>
		<td><%= req.isApproved() ? "Yes" : "No" %></td>
		<td><%= req.getReqId()  %></td>
		</tr>
	<%} %>
	
	</table>
</body>
</html>