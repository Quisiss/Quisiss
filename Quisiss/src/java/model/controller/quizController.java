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
import model.Classroom;
import model.Quiz;

/**
 *
 * @author Lenovo-Y50
 */
public class quizController {
    Connection conn = null;
    
        public ArrayList<Quiz> getQuizByClassId(int id){
        ArrayList<Quiz> quizs = new ArrayList();
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from quiz where classid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Quiz q = new Quiz(rs.getInt("classId"),rs.getInt("quizId"),rs.getString("quizName"),rs.getInt("quizTime"));
                quizs.add(q);
            }
           return quizs;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
        public static void main(String[] args) {
            quizController qc = new quizController();
            ArrayList<Quiz> quizs = qc.getQuizByClassId(1);
            for(int i=0;i<quizs.size();i++){
                System.out.println(quizs.get(i).getClassId()+"---"+quizs.get(i).getQuizId()+"---"+quizs.get(i).getQuizTime());
             }
    }
}
