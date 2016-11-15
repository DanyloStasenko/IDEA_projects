<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Log in</title>
	</head>
	
	<body>
		<form action="login" method="POST">
			<label>Username</label>
			<input type = "text" name = "username" value = "" >
			<br>
			<label>Password</label>
			<input type = "password" name = "password" value = "">
			<br>
			<input type = "submit" name = "submit" value = "LOG IN">
		</form>
		<a href="http://localhost:8080/jsp/index.jsp">Back</a>
	</body>
</html>