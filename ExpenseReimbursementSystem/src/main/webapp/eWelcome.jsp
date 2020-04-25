<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>

</head>
<body>
<%
String user = (String)session.getAttribute("username");
%>
<h3 style="text-align:center">Welcome <%out.print(user);%></h3>
<% 
if(session.getAttribute("username") == null) {
	response.sendRedirect("index.html");
}
%>

<form action="Logout">
	<input type="submit" value="logout">
</form>

</body>
</html>