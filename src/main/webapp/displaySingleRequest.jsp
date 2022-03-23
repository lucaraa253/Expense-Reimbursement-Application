<%@page import="com.training.ers.models.Request"%>
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
		String id3 = (String) request.getParameter("id");
		int thisId = Integer.parseInt(id3);
		RequestDAO requestDAO = new RequestDAOImpl();
		Request req = new Request();
		req = requestDAO.viewSingleRequest(thisId);
		%>
	<h1 style="margin: 0 auto; text-align:center;"><a href="displayRequests.jsp">View all Requests</a></h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="submitRequest.html">Submit Request</a></h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="DisplayUserDetails.jsp">My Information</a></h1>
	<h1 style="margin: 0 auto; text-align:center;"><a href="index.jsp">Log out</a></h1>
	<table border="2" cellspacing="10" cellpadding="10" class="table table-striped">
	<th>Request Id</th><th>Description</th><th>Ammount</th><th>Approved</th><th>Employee ID</th>
		<tr>
		<td><%= req.getId() %></td>
		<td><%= req.getDescription() %></td>
		<td><%= req.getAmount() %></td>
		<td><%= req.isApproved() %></td>
		<td><%= req.getReqId() %></td>
		</tr>
	</table>
	<a href="index.jsp">Logout</a>
</body>
</html>