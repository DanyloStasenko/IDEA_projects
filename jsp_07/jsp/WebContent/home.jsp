<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="jsp.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	Here is home.jsp text
	<br>
	a: <%= request.getAttribute("a") %>
	b: <%= request.getAttribute("b") %>
	status: <%= request.getAttribute("status") %>
	<br>
	
	Our user:
	<% 
		User user = (User) request.getAttribute("user");
		out.println(user.getFirstName());
		out.println(user.getLastName());
		out.println(user.getAge());
	%>
	
	<br>
	
	first name: ${user.firstName} <br>
	last name: ${user.lastName} <br>
	age: ${user.age} <br>
</body>
</html>