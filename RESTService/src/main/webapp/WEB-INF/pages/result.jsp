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

    <c:if test="${!empty message}">
       <h3>${message}</h3>
    </c:if>
        <table class="tg">
            <%  // sorry for this shit code :(
                // but it's working with all tables
                // I mean, that table 3x3 will look as good as table 5x2
                // and You don't need to customize this code for tables with different sizes

                String openTr = "<tr>";
                String closeTr = "</tr>";
                String openTh = "<th>";
                String closeTh = "</th>";
                String openTd = "<td>";
                String closeTd = "</td>";

                out.print(openTr);

                int columnCount = 0;
                // table headers (column names)
                List<Object> columns = (List<Object>) request.getAttribute("columns");
                if(columns != null){
                    for(Object column : columns){
                        out.println(openTh + column + closeTh);
                        columnCount++;
                    }
                }

                out.print(closeTh + closeTr);
                out.print(openTr);

                // table content
                List<Object> objects = (List<Object>) request.getAttribute("result");
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
    </body>
</html>
