<%-- 
    Document   : results
    Created on : 14-Dec-2020, 17:30:54
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <h1>The retrieved Data :</h1>

        <%=(String)(request.getAttribute("first_name"))%>
    </body>
</html>
