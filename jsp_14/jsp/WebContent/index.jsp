<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" isThreadSafe="true" isErrorPage="false" info="some info"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lesson 14</title>
	</head>
	
	<body>
		JSP: Lesson 14: "Upload file"
		<br>
		<a href="http://localhost:8080/jsp/home.html">Home</a> <br>
		<br> 
		<a href="http://localhost:8080/jsp/fileshow">Show File</a> <br>
		<a href="http://localhost:8080/jsp/filedownload">Download File</a>

		<form action="filedownload" method="POST" enctype="multipart/form-data">
			<input type = "file" name = "file">
			<input type = "submit" name = "submit" value = "Upload">
		</form>

	</body>
</html>