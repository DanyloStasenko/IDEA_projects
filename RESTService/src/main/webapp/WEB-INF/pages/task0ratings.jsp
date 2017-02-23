<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>task0 ratings</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }
        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }
        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
<c:if test="${!empty ratings}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="200">Title</th>
            <th width="200">Director</th>
            <th width="80">Rating</th>
            <th width="250">Date</th>
        </tr>
        <c:forEach items="${ratings}" var="rate">
            <tr>
                <td>${rate.id}</td>
                <td>${rate.movieId}</td>
                <td>${rate.userId}</td>
                <td>${rate.rating}</td>
                <td>${rate.date}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
