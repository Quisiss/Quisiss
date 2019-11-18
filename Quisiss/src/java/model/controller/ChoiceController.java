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
import model.Classroom;
import model.Question;
import model.Quiz;

/**
 *
 * @author Lenovo-Y50
 */
public class ChoiceController {

    Connection conn;

    public ArrayList<Choice> getChoiceByQuestionId(Question q) {
        questionController qc = new questionController();
        ArrayList<Choice> choices = new ArrayList();
        try {
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from choice where classid = ? and quizid = ? and questionid = ?");
            ps.setInt(1, q.getClassId());
            ps.setInt(2, q.getQuizid());
            ps.setInt(3, q.getQuestionid());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Choice c = new Choice(rs.getInt("questionid"), rs.getInt("quizid"), rs.getString("choiceid"), rs.getInt("classid"), rs.getString("choice"));
                choices.add(c);
            }
            return choices;
        } catch (SQLException ex) {
            Logger.getLogger(ChoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void addNewChoice(Question q, String choiceid, String choice) {
        try {
            quizController qc = new quizController();
            conn = BuildConnection.getConnection();
            String statement = "insert into choice(questionid,quizid,choiceid,classid,choice) values (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setInt(1, q.getQuestionid());
            ps.setInt(2, q.getQuizid());
            ps.setString(3, choiceid);
            ps.setInt(4, q.getClassId());
            ps.setString(5, choice);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(quizController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteChoiceByQuestionId(Question q){
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from choice where classid = ? and quizid = ? and questionid = ?");
            ps.setInt(1, q.getClassId());
            ps.setInt(2, q.getQuizid());
            ps.setInt(3, q.getQuestionid());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteChoiceById(Question q, String choiceid) {
        try {
            ChoiceController chc = new ChoiceController();
            classController cc = new classController();
            quizController qc = new quizController();
            questionController quc = new questionController();
            conn = BuildConnection.getConnection();
            ArrayList<Choice> choice = chc.getChoiceByQuestionId(q);
            String choiceId = choiceid;
            int start = 0;
            for (int i = 0; i < choice.size(); i++) {
                if (choice.get(i).getChoiceId().equals(choiceid)) {
                    start = i;
                }
            }
            PreparedStatement ps = conn.prepareStatement("delete from choice where classid = ? and quizid = ? and questionid = ? and choiceid = ?");
            ps.setInt(1, q.getClassId());
            ps.setInt(2, q.getQuizid());
            ps.setInt(3, q.getQuestionid());
            ps.setString(4, choiceid);
            ps.executeUpdate();
            if (choice.size() <= 0) {
                Classroom c = cc.getClassroomById(q.getClassId());
                quc.deleteQuestionById(q.getClassId(), q.getQuizid(), q.getQuestionid());
            } else {
                String nextId = null;
                for (int i = start; i < choice.size(); i++) {
                    if (i == start) {
                        nextId = choice.get(i).getChoiceId();
                        PreparedStatement ps2 = conn.prepareStatement("UPDATE choice SET choiceid = ? WHERE choiceid = ?");
                        ps2.setString(1, choiceid);
                        ps2.setString(2, choice.get(i).getChoiceId());
                        ps2.executeUpdate();
                        System.out.println(nextId);
                    } else {
                        String nextt = choice.get(i).getChoiceId();
                        PreparedStatement ps3 = conn.prepareStatement("UPDATE choice SET choiceid = ? WHERE choiceid = ?");
                        ps3.setString(1, nextId);
                        ps3.setString(2, choice.get(i).getChoiceId());
                        //ps2.executeUpdate();
                        nextId = nextt;
                        System.out.println(nextId);
                        ps3.executeUpdate();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChoiceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ChoiceController chc = new ChoiceController();
        classController cc = new classController();
        questionController qc = new questionController();
        quizController q = new quizController();
        Classroom c = cc.getClassroomById(2);
        Quiz qq = q.getQuizById(c, 2);
        Question ques = qc.getQuestionById(qq, 2);
//        chc.addNewChoice(ques, "a", "wtf");
//        chc.addNewChoice(ques, "b", "is");
//        chc.addNewChoice(ques, "c", "this");
        ArrayList<Choice> c1 = chc.getChoiceByQuestionId(ques);;
        for (int i = 0; i < c1.size(); i++) {
            System.out.println(c1.get(i).getChoiceId() + c1.get(i).getChoice());
        }
        chc.deleteChoiceById(ques, "a");
    }
}
