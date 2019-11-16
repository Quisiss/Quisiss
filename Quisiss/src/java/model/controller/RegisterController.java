/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import database.BuildConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Register;

/**
 *
 * @author Acer Nitro
 */
public class RegisterController {
    public String registerUser(Register register){
 
    String email = register.getEmail();
    String userName = register.getUserName();
    String password = register.getPassword();
 
    Connection con = null;
    PreparedStatement preparedStatement = null;
 
    try{
        con = BuildConnection.getConnection();
        String query = "insert into users(email,userName,password) values (?,?,?)"; //Insert user details into the table 'USERS'
        preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, userName);
        preparedStatement.setString(3, password);
 
        int i= preparedStatement.executeUpdate();
 
        if (i!=0)  //Just to ensure data has been inserted into the database
        return "SUCCESS"; 
    }catch(SQLException e){
        e.printStackTrace();
    }
 
    return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
    
    }
}
