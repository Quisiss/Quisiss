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
    
    public Quiz getQuizById(Classroom c,int quizid){
        try{
            classController cc = new classController();
            quizController qc = new quizController();
            questionController quc = new questionController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from quiz where classid = ? and quizid = ?");
            ps.setInt(1, c.getClassId());
            ps.setInt(2, quizid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               return new Quiz(rs.getInt("classid"),rs.getInt("quizid"),rs.getString("quizname"),rs.getInt("quizTime"));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(questionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Quiz> getQuizByClassId(int id) {
        ArrayList<Quiz> quizs = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from quiz where classid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Quiz q = new Quiz(rs.getInt("classId"), rs.getInt("quizId"), rs.getString("quizName"), rs.getInt("quizTime"));
                quizs.add(q);
            }
            return quizs;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteQuizByClassId(int classid){
        try{
            classController cc = new classController();
            questionController qc = new questionController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("delete from quiz where classid = ?");
            ps1.setInt(1, classid);
            ps1.executeUpdate();
            ArrayList<Classroom> classes = cc.getAllClassroom();
            System.out.println(classes.size());
            for (int i = classid; i <= classes.size(); i++) {
                PreparedStatement ps2 = conn.prepareStatement("UPDATE quiz SET classid = ? WHERE classid = ?");
                ps2.setInt(1, i);
                ps2.setInt(2, i+1);
                ps2.executeUpdate();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getNewQuizId(Classroom c) {
        int id = 0;
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select max(quizid) from quiz where classid = ?");
            ps.setInt(1, c.getClassId());
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

    public void createNewQuiz(Classroom c, String quizName, int time) {
        try {
            quizController qc = new quizController();
            conn = BuildConnection.getConnection();
            String statement = "insert into quiz(classid,quizid,quizname,quiztime) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setInt(1, c.getClassId());
            ps.setInt(2, qc.getNewQuizId(c));
            ps.setString(3, quizName);
            ps.setInt(4, time);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(quizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteQuizById(Classroom c,int quizId){
        try{
            System.out.println(c);
            System.out.println(c.getClassId());
            System.out.println(quizId);
            quizController qc = new quizController();
            Quiz q = qc.getQuizById(c, quizId);
            System.out.println("quiz1"+q);
            ChoiceController cc = new ChoiceController();
            cc.deleteChoiceByQuizId(q);
            questionController quc = new questionController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("delete from quiz where classid = ? and quizId = ?");
            ps1.setInt(1, c.getClassId());
            ps1.setInt(2, quizId);
            ps1.executeUpdate();
            ArrayList<Quiz> quizs = qc.getQuizByClassId(c.getClassId());
            for (int i = quizId; i <= quizs.size(); i++) {
                System.out.println(quizs.size());
                PreparedStatement ps2 = conn.prepareStatement("UPDATE quiz SET quizid = ? WHERE classid = ? and quizId = ?");
                ps2.setInt(1, i);
                ps2.setInt(2, c.getClassId());
                ps2.setInt(3, i+1);
                ps2.executeUpdate();
            }
            quc.deleteQuestionByQuizId(quizId, c.getClassId());
            System.out.println("ques"+q);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        classController cc = new classController();
        Classroom c = cc.getClassroomById(1);
        quizController qc = new quizController();
        ArrayList<Quiz> quizs = qc.getQuizByClassId(1);
        for (int i = 0; i < quizs.size(); i++) {
            System.out.println(quizs.get(i).getClassId() + "---" + quizs.get(i).getQuizId() + "---  " + quizs.get(i).getQuizTime());
        }
        System.out.println(qc.getNewQuizId(c));
        /*Quiz q = qc.getQuizById(c, 2);
        System.out.println(q.getClassId());
        System.out.println(q.getQuizId());
        System.out.println(q.getQuizName());
        System.out.println(q.getQuizTime());*/
        //qc.createNewQuiz(c, "testquiz2", 600);
        //qc.deleteQuizById(c, 2);
        //qc.deleteQuizByClassId(2);
    }
}
