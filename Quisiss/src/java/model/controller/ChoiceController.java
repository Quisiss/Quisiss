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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Choice;

/**
 *
 * @author Lenovo-Y50
 */
public class ChoiceController {
    Connection conn;
    
    public ArrayList<Choice> getChoiceByQuestionId(int classid,int quizid,int questionid){
        ArrayList<Choice> choices = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from choice where classid = ? and quizid = ? and questionid = ?");
            ps.setInt(1, classid);
            ps.setInt(2,quizid);
            ps.setInt(3,questionid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(rs.getInt("questionid"),rs.getInt("quizid"),rs.getString("choiceid"),rs.getInt("classid"),rs.getString("choice"));
                choices.add(c);
            }
            return choices;
        } catch (SQLException ex) { 
            Logger.getLogger(ChoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
