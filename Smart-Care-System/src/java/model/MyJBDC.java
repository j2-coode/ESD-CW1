/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author ben
 */
public class MyJBDC {

    public static void main(String[] args) {

        try {
            //Connect to MyDB
            String host = "jdbc:derby://localhost:1527/MyDB";
            String uName = "admin";
            String uPass = "admin";
            Connection con = DriverManager.getConnection(host, uName, uPass);

            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM APP.CLIENTS";
            ResultSet rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String name = rs.getString("CNAME");
                String Address = rs.getString("CADDRESS");
                String type = rs.getString("CTYPE");
                String user_name = rs.getString("UNAME");

                System.out.println(name + " " + Address + " " + type + " " + user_name);
                String test = name + " " + Address + " " + type + " " + user_name;
            }
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
