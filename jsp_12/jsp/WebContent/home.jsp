<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="jsp.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home page</title>
	</head>
	
	<body>
		This home.jsp!  
		<br>
		 <% 
		 	User user = (User)(session.getAttribute("PRINCIPAL")); 
		 	out.println("Hello, "+user.getFirstName());
		 	out.println("You are logged in as "+user.getUsername());
		 %>
		<br>
		<a href="http://localhost:8080/jsp/logout">Logout</a>
	</body>
</html>