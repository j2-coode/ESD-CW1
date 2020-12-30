/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.*;
import java.sql.*;
/**
 *
 * @author ben
 */
public class MyJBDC {
    //Connect to DB
    public static Connection getConnection() {
        Connection con=null;
        try {
            //Connect to MyDB
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/MyDB", "admin", "admin");
        } 
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }return con;
    }
    //Code for login auth
    public static int loginauth(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection(); 
            PreparedStatement ps=con.prepareStatement("select * from APP.USERS where UNAME = ? and PASSWD = ? ");
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            boolean test = rs.next();
            if (test){
                status = 1;
            }
            else{
                status = 0;
            }
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
    //Code for adding to USERS table
    public static int saveuser(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.USERS(UNAME, PASSWD, ROLE) values (?,?,?)");   
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getRole());
            
            status=ps.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
    //Code for adding to CLIENT & USER table
    public static int savepatient(com.UserInput e){
        int status=0;
        try {
            Connection con=MyJBDC.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into APP.USERS(UNAME, PASSWD, ROLE) values (?,?,?)");
            PreparedStatement ts=con.prepareStatement("insert into APP.CLIENTS(CNAME, CADDRESS, CTYPE, UNAME) values (?,?,?,?)");   
            
            ps.setString(1,e.getUsername());
            ps.setString(2,e.getPassword());
            ps.setString(3,e.getRole());
            ts.setString(1,e.getName());
            ts.setString(2,e.getAddress());
            ts.setString(3,e.getType());
            ts.setString(4,e.getUsername());

            
            status=ps.executeUpdate();
            status=ts.executeUpdate();
            con.close();
        }catch(Exception ex) {ex.printStackTrace();}
        return status;
    }
    public static List<com.UserInput> getAllPatients(){
        List<com.UserInput> list=new ArrayList<com.UserInput>();
        
        try{
            Connection con=MyJBDC.getConnection();
            //PreparedStatement ps=con.prepareStatement("select * from APP.CLIENTS");
            
            PreparedStatement ps=con.prepareStatement("select * from APP.CLIENTS where CTYPE = 'NHS'");
           
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                com.UserInput e=new com.UserInput();
                e.setID(rs.getInt(1));
                e.setUsername(rs.getString(2));
                e.setName(rs.getString(3));
                e.setAddress(rs.getString(4));
                e.setType(rs.getString(5));
                list.add(e);
            }
            con.close();
        }catch(Exception e){e.printStackTrace();}
        return list;
    }
}
