<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" isThreadSafe="true" isErrorPage="false" info="some info"%>

<%-- <%@ page import ="path" buffer = "25kb"%> --%>
<%-- <%@ taglib uri = "/tag" prefix = "pr" %> --%> 	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lesson 5</title>
</head>
<body>
	JSP: Lesson 5: "Directives"
	<br>
	Hello, my name is Dan!
	<br>
	<a href="http://localhost:8080/jsp/home.html">Home</a>
	<br>
	
	<%@ include file="/file.html" %>
	
	<!-- <pr:myTag> </pr:myTag> -->
	
</body>
</html>