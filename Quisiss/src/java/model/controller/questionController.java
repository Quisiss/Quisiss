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
    
    public Question getQuestionById(Quiz q,int questionid){
        try{
            classController cc = new classController();
            quizController qc = new quizController();
            questionController quc = new questionController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from question where classid = ? and quizid = ? and questionid = ?");
            ps.setInt(1, q.getClassId());
            ps.setInt(2, q.getQuizId());
            ps.setInt(3, questionid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               return new Question(rs.getInt("quizid"),rs.getInt("questionid"),rs.getString("question"),rs.getString("answer"),rs.getInt("classid"));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(questionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
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
            ChoiceController cc = new ChoiceController();
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
    
    public void deleteQuestionById(int classid,int quizid,int questionid){
        try{
            int questionid1 = questionid;
            classController cc = new classController();
            quizController qc = new quizController();
            questionController quc = new questionController();
            ChoiceController classc = new ChoiceController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from question where classid = ? and quizid = ? and questionid = ?");
            ps.setInt(1, classid);
            ps.setInt(2, quizid);
            ps.setInt(3, questionid);
            ps.executeUpdate();
            ArrayList<Question> question = quc.getQuestionByQuizId(classid, quizid);
            if(question.size()<=0){
                System.out.println("5555");
                Classroom c = cc.getClassroomById(classid);
                qc.deleteQuizById(c, quizid);
            }else{
                System.out.println("66666");
                for (int i = questionid; i <= question.size(); i++) {
                    PreparedStatement ps2 = conn.prepareStatement("UPDATE question SET questionid = ? WHERE questionid = ?");
                    ps2.setInt(1, i);
                    ps2.setInt(2, i+1);
                    ps2.executeUpdate();
                }
            }
            System.out.println("77777");
            System.out.println("55555" + quc.getQuestionById(qc.getQuizById(cc.getClassroomById(classid), quizid), questionid1));
            classc.deleteChoiceByQuestionId(quc.getQuestionById(qc.getQuizById(cc.getClassroomById(classid), quizid), questionid1));
        } catch (SQLException ex) {
            Logger.getLogger(questionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        classController cc = new classController();
        questionController qc = new questionController();
        quizController q = new quizController();
        Classroom c = cc.getClassroomById(2);
        System.out.println(c.getClassId());
//        Quiz qq = q.getQuizById(c, 2);
//        System.out.println(qq);
//        System.out.println(qq.getClassId());
        //qc.deleteQuestionByQuizId(1, 1);
        //qc.deleteQuestionByClassId(3);
        qc.createNewQuestion(2, "questionaddtest1", "d",2);
        //qc.deleteQuestionById(2, 2, 1);
//        Question ques = qc.getQuestionById(qq, 2);
//        System.out.println(ques.getQuestionid());
//        System.out.println(ques.getQuestion());
        //System.out.println(qc.getNewQuestionId(1)); 
        //System.out.println(qc.getQuestionByQuizId(1,2));
        //System.out.println(qc.getAnswerByQuizId(1,1));
    }
}
