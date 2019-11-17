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
import javax.xml.registry.infomodel.User;
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
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            ps.setString(1, username);
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
    
    public boolean addUser(Users u){
        
        conn = BuildConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO users(userid, username, password, email) values (0,?,?,?)");
            ps.setInt(1, u.getUserId());
            ps.setString(2, u.getUserName());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getEmail());
            
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public static void main(String[] args) {
        UsersController usc = new UsersController();
        Users u = usc.findUsersById(1);
        System.out.println(u);
    }
}
