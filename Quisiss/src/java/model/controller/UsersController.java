/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import database.BuildConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Users;

/**
 *
 * @author Acer Nitro
 */
public class UsersController {
    Connection conn;

    public Users findUsersByUsername(String username) {
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE lower(username) = ?");
            ps.setString(1, username.toLowerCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Users(rs.getInt("userid"), rs.getString("username"), rs.getString("password"), rs.getInt("classid"), rs.getString("email"));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) { 
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public Users findUsersById(int id) {
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE userid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Users(rs.getInt("userid"), rs.getString("username"), rs.getString("password"), rs.getInt("classid"), rs.getString("email"));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) { 
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public Users findUsersByEmail(String email) {
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE lower(email) = ?");
            ps.setString(1, email.toLowerCase());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Users(rs.getInt("userid"), rs.getString("username"), rs.getString("password"), rs.getInt("classid"), rs.getString("email"));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) { 
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public boolean addUser(Users u){
        
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(username, password, email) values (?,?,?)");
            
            ps.setString(1, u.getUserName());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean setPassword(Users u){
        
        conn = BuildConnection.getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE users SET password = ? WHERE username = ?");
            ps.setString(1, u.getPassword());
            ps.setString(2, u.getUserName());
            ps.executeUpdate();
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return false;
    }
    
    public boolean setUsername(Users u){
        
        conn = BuildConnection.getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE users SET username = ? WHERE userid = ?");
            ps.setString(1, u.getUserName());
            ps.setInt(2, u.getUserId());
            ps.executeUpdate();
            return true;
        }catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return false;
    }

    public static void main(String[] args) {
        UsersController usc = new UsersController();
        Users u = usc.findUsersByUsername("steve");
        u.setUserName("steve1");
        //u.setPassword("1234");
        usc.setUsername(u);
        System.out.println(u.toString());
    }
}
