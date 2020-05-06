/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lenovo-Y50
 */
public class Quiz {
    private int classId;
    private int quizId;
    private String quizName;
    private int quizTime;
    private String type;

    public Quiz(int classId, int quizId, String quizName, int quizTime, String type) {
        this.classId = classId;
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizTime = quizTime;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Quiz(int classId, int quizId, String quizName, int quizTime) {
        this.classId = classId;
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizTime = quizTime;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public int getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(int quizTime) {
        this.quizTime = quizTime;
    }
    
    
}
