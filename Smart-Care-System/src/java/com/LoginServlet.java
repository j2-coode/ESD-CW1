/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.MyJBDC;

/**
 *
 * @author ben
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        PrintWriter out = response.getWriter();

        // get user input for username and password
        String username = (String) request.getParameter("username");
        String password = (String) request.getParameter("password");

        //Set variables to user input
        UserInput e = new UserInput();
        e.setUsername(username);
        e.setPassword(password);
       

        int status = model.MyJBDC.loginauth(e);
        if (status > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user", "doctor");
            //setting session to expiry in 20 mins
            session.setMaxInactiveInterval(20 * 60);
            Cookie userName = new Cookie("user", username);
            userName.setMaxAge(20 * 60);
            response.addCookie(userName);
            out.println("<p>Login successful</p>");
            request.getRequestDispatcher("LoginSuccess.jsp").include(request, response);
        } else {
            out.println("<p><font color=\"red\">Either user name or password is wrong.</font></p>");
            request.getRequestDispatcher("index.html").include(request, response);
        }
        out.close();
    }

}
