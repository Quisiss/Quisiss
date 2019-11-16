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
import model.Question;
/**
 *
 * @author Lenovo-Y50
 */
public class questionController {
    Connection conn = BuildConnection.getConnection();
    
    public int getNewQuestionId(int quizId,int classId) {
        int id = 0;
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select max(questionid) from question where quizId = ? and classid = ?");
            ps.setInt(1, quizId);
            ps.setInt(2, classId);
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
    
    public void createNewQuestion(int quizId, String question, String answer,int classId) {
        try {
            questionController qc = new questionController();
            conn = BuildConnection.getConnection();
            String statement = "insert into question(quizid,questionid,question,answer,classid) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setInt(1,quizId);
            ps.setInt(2, qc.getNewQuestionId(quizId,classId));
            ps.setString(3, question);
            ps.setString(4, answer);
            ps.setInt(5, classId);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(quizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Question> getQuestionByQuizId(int classid,int id) {
        ArrayList<Question> questions = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from question where quizid = ? and classid = ?");
            ps.setInt(1, id);
            ps.setInt(2,classid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question q = new Question(rs.getInt("quizid"), rs.getInt("questionid"), rs.getString("question"), rs.getString("answer"),rs.getInt("quizid"));
                questions.add(q);
            }
            return questions;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> getAnswerByQuizId(int classid,int id) {
        ArrayList<String> answers = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select answer from question wwhere quizid = ? and class id = ?");
            ps.setInt(1, id);
            ps.setInt(2, classid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String answer = rs.getString("answer");
                answers.add(answer);
            }
            return answers;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteQuestionByQuizId(int quizId,int classid){
        try{
            quizController qc = new quizController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("delete from question where quizid = ? and classid = ?");
            ps1.setInt(1, quizId);
            ps1.setInt(2, classid);
            ps1.executeUpdate();
            ArrayList<Quiz> quizs = qc.getQuizByClassId(classid);
            for (int i = quizId; i <= quizs.size(); i++) {
                PreparedStatement ps2 = conn.prepareStatement("UPDATE quiz SET quizId = ? WHERE quizId = ? and classid = ?");
                ps2.setInt(1, i);
                ps2.setInt(2, i+1);
                ps2.setInt(3,classid);
                ps2.executeUpdate();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteQuestionByClassId(int classid){
        try{
            quizController qc = new quizController();
            classController cc = new classController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("delete from question where classid = ?");
            ps1.setInt(1, classid);
            ps1.executeUpdate();
            ArrayList<Classroom> classes = cc.getAllClassroom();
            for (int i = classid; i <= classes.size(); i++) {
                PreparedStatement ps2 = conn.prepareStatement("UPDATE question SET classid = ? WHERE classid = ?");
                ps2.setInt(1, i);
                ps2.setInt(2, i+1);
                ps2.executeUpdate();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        questionController qc = new questionController();
        //qc.deleteQuestionByQuizId(1, 1);
        //qc.deleteQuestionByClassId(3);
        qc.createNewQuestion(2, "questionaddtest1", "d",1);
        //System.out.println(qc.getNewQuestionId(1)); 
        //System.out.println(qc.getQuestionByQuizId(1,2));
        //System.out.println(qc.getAnswerByQuizId(1,1));
    }
}
