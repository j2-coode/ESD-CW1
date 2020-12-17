<%-- 
    Document   : add0
    Created on : 14-Dec-2020, 16:52:14
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <h1>ADD!</h1>
        <h2>User's details:</h2>
        <form method="POST" action="NewUser.do">     
            <table>
                <tr>
                    <th></th>
                    <th>Please provide your following details</th>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td><input type="text" name="role"/></td>
                </tr>                
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr> 
                    <td> <input type="submit" value="Add User"/></td>
                </tr>
            </table>
        </form>   
                <%--
            if (i++>0 && request.getAttribute("message")!=null) {
                out.println(request.getAttribute("message"));
                i--;
            }
        --%>
    </body>
</html>
