<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lesson 4</title>
</head>
<body>
	JSP: Lesson 4: "Scriplets. Don't use it!"
	<br>
	Hello, my name is Dan!
	<br>
	<a href="http://localhost:8080/jsp/home.html">Home</a>
	<br>
	
	<!-- Ititialization -->
	<%!
		String s = new String();
		int a = 7;
		int b = 8;
		int c = 0;
	%>
	
	<!-- Java code -->
	<%
		out.println(c);
		if(a==b){
		c = a + b;
	
		}else{
		c = a - b;
		}
	%>
	
	<!-- Output -->
	<%= c %>
	
</body>
</html>