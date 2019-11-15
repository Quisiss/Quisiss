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
import model.Quiz;
/**
 *
 * @author Lenovo-Y50
 */
public class questionController {
    Connection conn = BuildConnection.getConnection();
    
    public int getNewQuestionId(int quizId) {
        int id = 0;
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select max(questionid) from question where quizId = ?");
            ps.setInt(1, quizId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            conn.close();
            return id + 1;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id + 1;
    }
    
    public void createNewQuestion(int quizId, String question, String answer) {
        try {
            questionController qc = new questionController();
            conn = BuildConnection.getConnection();
            String statement = "insert into question(quizid,questionid,question,answer) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setInt(1,quizId);
            ps.setInt(2, qc.getNewQuestionId(quizId));
            ps.setString(3, question);
            ps.setString(4, answer);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(quizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        questionController qc = new questionController();
        qc.createNewQuestion(1, "questionaddtest1", "d");
        System.out.println(qc.getNewQuestionId(1)); 
    }
}
