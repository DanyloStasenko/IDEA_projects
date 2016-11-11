<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" isThreadSafe="true" isErrorPage="false" info="some info"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lesson 8</title>
	</head>
	<body>
		JSP: Lesson 8: "Sending data using GET/POST requests"
		<br>
			<a href="http://localhost:8080/jsp/home.html">Home</a>
		<br>
		
		<form action="/jsp/home.html" method="POST">
			<input type="text" name="a" value=""/>
			<input type="text" name="b" value=""/>
			<input type="submit" name="submit" value="Go"/>
		</form>
		
	</body>
</html>