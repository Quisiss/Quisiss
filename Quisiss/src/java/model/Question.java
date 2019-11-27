/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import model.controller.ChoiceController;
import model.controller.classController;
import model.controller.questionController;
import model.controller.quizController;

/**
 *
 * @author Lenovo-Y50
 */
public class Question {
    private int quizid;
    private int questionid;
    private String question;
    private String answer;
    private int classId;
    private ArrayList<Choice> choices;

    public Question(int quizid, int questionid, String question, String answer, int classId) {
        this.quizid = quizid;
        this.questionid = questionid;
        this.question = question;
        this.answer = answer;
        this.classId = classId;
    }
    
    public Question(int quizid, int questionid, String question, int classId) {
        this.quizid = quizid;
        this.questionid = questionid;
        this.question = question;
        this.classId = classId;
    }
    public Question(int quizid,String question, int classId) {
        this.quizid = quizid;
        this.question = question;
        this.classId = classId;
    }


    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getQuizid() {
        return quizid;
    }

    public void setQuizid(int quizid) {
        this.quizid = quizid;
    }

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
