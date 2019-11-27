/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public class Answer {
    private int answerId;
    private String text;
    private int userId;
    private int questionId;

    public Answer(String text, int userId, int questionId) {
        this.text = text;
        this.userId = userId;
        this.questionId = questionId;
    }

    public Answer(int answerId, String text, int userId, int questionId) {
        this.answerId = answerId;
        this.text = text;
        this.userId = userId;
        this.questionId = questionId;
    }
   
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "Answer{" + "answerId=" + answerId + ", text=" + text + ", userId=" + userId + ", questionId=" + questionId + '}';
    }
}
