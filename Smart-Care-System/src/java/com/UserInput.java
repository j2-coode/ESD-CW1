/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

/**
 *
 * @author ben
 */
public class UserInput {
    private int id;
    private String name,username,password,role,address,type,option;
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    //name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //Username
    public String getUsername() {
	return username;
    }
    public void setUsername(String username) {
            this.username = username;
    }
    //Password
    public String getPassword() {
            return password;
    }
    public void setPassword(String password) {
            this.password = password;
    }
    //Role
    public String getRole() {
            return role;
    }
    public void setRole(String role) {
            this.role = role;
    }   
    //address
    public String getAddress() {
            return address;
    }
    public void setAddress(String address) {
            this.address = address;
    }
    //type
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    //option
    public String getOption(){
        return option;
    }
    public void setOption(String option){
        this.option = option;
    }
}
