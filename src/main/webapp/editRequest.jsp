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
		String id3 = (String) request.getParameter("id");
		int thisId = Integer.parseInt(id3);
		RequestDAO requestDAO = new RequestDAOImpl();
		Request req = new Request();
		req = requestDAO.viewSingleRequest(thisId);
	%>
	
	<form class="form-style" action="ExecuteUpdateController"
		onsubmit="return validateSignUpForm()" name="signupform" method = "get">
		<table cellspacing="20" cellpadding="20" bgcolor="cyan">
			<tr>
				<td><label>* Description : </label></td>
				<td><input type="text" name="description" id="description" value="<%= req.getDescription() %>"></td>
			</tr>
			<tr>
				<td><label>* Ammount : </label></td>
				<td><input type="number" name="ammount" id="ammount" value="<%= req.getAmount() %>">
			</tr>
			<tr>
				<input type="hidden" name="id" id="id" value="<%= thisId %>">
				<td><input type="submit" value="SignUp"></td>
				<td><input type="reset" value="Clear"></td>
			</tr>

		</table>
	</form>

</body>
</html>