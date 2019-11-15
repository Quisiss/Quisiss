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
    private int quizTine;

    public Quiz(int classId, int quizId, String quizName, int quizTine) {
        this.classId = classId;
        this.quizId = quizId;
        this.quizName = quizName;
        this.quizTine = quizTine;
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

    public int getQuizTine() {
        return quizTine;
    }

    public void setQuizTine(int quizTine) {
        this.quizTine = quizTine;
    }
    
}
