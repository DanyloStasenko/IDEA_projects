<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Results</title>
    <style type="text/css">
        .center {
            margin: 0 auto;
            width: 70%;
        }
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
        h3{
            font-family: Arial, sans-serif;
        }
    </style>
</head>
<body>
<div class="center">
    <c:if test="${!empty message}"><h3>${message}</h3></c:if>
    <c:if test="${!empty rows}">
        <table class="tg">
            <tr>
                <c:forEach items="${tableHeaders}" var="tableHeader">
                    <c:if test="${tableHeader.movieId}"> <th width="100">Movie Id</th> </c:if>
                    <c:if test="${tableHeader.userId}">  <th width="100">User ID</th> </c:if>
                    <c:if test="${tableHeader.ratingId}">  <th width="100">Rating ID</th> </c:if>
                    <c:if test="${tableHeader.rating}">  <th width="100">Rating</th> </c:if>
                    <c:if test="${tableHeader.ratingDate}">  <th width="100">Rating Date</th> </c:if>
                    <c:if test="${tableHeader.userTitle}">  <th width="100">User Title</th> </c:if>
                    <c:if test="${tableHeader.movieTitle}">  <th width="100">Movie Title</th> </c:if>
                    <c:if test="${tableHeader.movieDirector}">  <th width="100">Movie Director</th> </c:if>
                </c:forEach>
            </tr>
            <c:forEach items="${rows}" var="row">
                <tr>
                    <c:if test="${row.movieId != 0}">  <td>${row.movieId}</td> </c:if>
                    <c:if test="${row.userId != 0}">  <td>${row.userId}</td> </c:if>
                    <c:if test="${row.ratingId != 0}">  <td>${row.ratingId}</td> </c:if>
                    <c:if test="${row.ratingRating != 0}">  <td>${row.ratingRating}</td> </c:if>
                    <c:if test="${!empty row.ratingDate}">  <td>${row.ratingDate}</td> </c:if>
                    <c:if test="${!empty row.userName}">  <td>${row.userName}</td> </c:if>
                    <c:if test="${!empty row.movieTitle}">  <td>${row.movieTitle}</td> </c:if>
                    <c:if test="${!empty row.movieDirector}">  <td>${row.movieDirector}</td> </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
