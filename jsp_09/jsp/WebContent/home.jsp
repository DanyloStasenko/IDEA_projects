<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="jsp.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<%
		Cookie [] cookies = request.getCookies();
		Cookie cookie = null;
		for(Cookie cookieRequest : cookies){
			if(cookieRequest.getName().equals("coo")) {
				cookie = cookieRequest;
				break;
			}
		}
	
	%>
	value: <% out.print(cookie.getValue()); %>
	
</body>
</html>