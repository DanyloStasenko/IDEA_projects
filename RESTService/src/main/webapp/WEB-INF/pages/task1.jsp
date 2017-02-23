<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Results:</title>
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
                width: 200px;
            }
            h3{
                font-family: Arial;
            }
        </style>
    </head>
    <body>
        <h1>Results:</h1>

        <c:if test="${!empty taskHeader && !empty task && !empty querySelect}">
            <h3>${taskHeader}</h3>
            <h3>${task}</h3>
            <h3>${querySelect}</h3>
        </c:if>
        <table class="tg">
            <%
                String openTr = "<tr>";
                String closeTr = "</tr>";
                String openTh = "<th>";
                String closeTh = "</th>";
                String openTd = "<td>";
                String closeTd = "</td>";

                out.print(openTr);

                int columnCount = 0;
                // table headers (column names)
                List<Object> columns = (List<Object>) request.getAttribute("selectedColumns");
                if(columns != null){
                    for(Object column : columns){
                        out.println(openTh + column + closeTh);
                        columnCount++;
                    }
                }

                out.print(closeTh + closeTr);
                out.print(openTr);

                // table content
                List<Object> objects = (List<Object>) request.getAttribute("selectedResult");
                if(objects != null){
                    Integer count = 0;
                    for(Object object : objects) {
                        out.println(openTd + object + closeTd);
                        count++;

                        if (columnCount == count) {
                            out.println(closeTr + openTr);
                            count = count - columnCount;
                        }
                    }
                }
                out.print(closeTd + closeTr);
            %>
        </table>
        <br>
        <br>
        <c:if test="${!empty queryUpdate}">
            <h3>${queryUpdate}</h3>
        </c:if>
        <table class="tg">
            <%
                out.print(openTr);
                int updatedColumnCount = 0;
                // table headers (column names)
                List<Object> updatedColumns = (List<Object>) request.getAttribute("updatedColumns");
                if(updatedColumns != null){
                    for(Object updatedColumn : updatedColumns){
                        out.println(openTh + updatedColumn + closeTh);
                        updatedColumnCount++;
                    }
                }

                out.print(closeTh + closeTr);
                out.print(openTr);

                // table content
                List<Object> updatedObjects = (List<Object>) request.getAttribute("updatedResult");
                if(updatedObjects != null){
                    Integer updatedCount = 0;
                    for(Object updatedObject : updatedObjects) {
                        out.println(openTd + updatedObject + closeTd);
                        updatedCount++;

                        if (updatedColumnCount == updatedCount) {
                            out.println(closeTr + openTr);
                            updatedCount = updatedCount - updatedColumnCount;
                        }
                    }
                }
                out.print(closeTd + closeTr);
            %>
        </table>
    </body>
</html>
