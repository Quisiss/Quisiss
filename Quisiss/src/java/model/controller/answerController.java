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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Answer;

/**
 *
 * @author Asus
 */
public class answerController {
    Connection conn = BuildConnection.getConnection();
    
    public boolean createAnswer(Answer a){
        try {
            PreparedStatement ps = conn.prepareStatement("insert into answer(text,userId,questionId) values(?,?,?)");
            ps.setString(1, a.getText());
            ps.setInt(2, a.getUserId());
            ps.setInt(3, a.getQuestionId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(answerController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    } 
    
    public static void main(String[] args) {
        Answer a = new Answer("text", 1, 1);
        answerController ac = new answerController();
        ac.createAnswer(a);
    }
}
