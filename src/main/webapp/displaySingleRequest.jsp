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

</head>
<body>
		<%
		HttpSession newsession = request.getSession();
		String actualId = (String) session.getAttribute("id");
		int thisId = Integer.parseInt(actualId);
		RequestDAO requestDAO = new RequestDAOImpl();
		Request req = new Request();
		req = requestDAO.viewSingleRequest(thisId);
	
	%>
	<table>
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