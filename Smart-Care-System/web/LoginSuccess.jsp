<%-- 
    Document   : LoginSuccess
    Created on : 14-Dec-2020, 16:50:17
    Author     : ben
--%>

<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
    <link rel="icon" href="https://www.seniorpedia.org/wp-content/uploads/2015/08/seniorpediaicons_health.png">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
        <title>Login Success Page</title>
    </head>
    <body>
        <%--
            //allow access only if session exists
            String user = (String) session.getAttribute("user");
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if(cookies !=null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("user")) userName = cookie.getValue();
                    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
                }
            }
        --%>
        
        
        <h2>Hi fucker, Login successful. Your Session ID=1</h2>
        <h3> Please select one of the following options: <h3>
        <form method="post" action="UserServlet"> 
        List options:</h4> 
            <input type="radio" name="option" value="list0">List all patients and all invoices per selected period (inc. costs)<br />
            <input type="radio" name="option" value="list0">List private patients and NHS patients, separately<br />
        <h4>Add options:</h4>
            <input type="radio" name="option" value="addUser">Add a new Doctor or Nurse user <br>
        <h4>Calendar options:</h4> 
            <input type="radio" name="option" value="calendar">Book an appointment with a Doctor <br>
            <input type="radio" name="option" value="calendar">Check daily surgery schedule <br>           

            <input type=submit value="Confirm"> <br />
            </form>
    </body>
</html>