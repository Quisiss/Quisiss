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
                return new Users(rs.getInt("id"), rs.getString("userName"), rs.getString("password"), rs.getInt("classID"), rs.getString("email"));
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
                return new Users(rs.getInt("id"), rs.getString("userName"), rs.getString("password"), rs.getInt("classID"), rs.getString("email"));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) { 
            Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String[] args) {
        UsersController usc = new UsersController();
        Users u = usc.findUsersById(1);
        System.out.println(u);
    }
}
