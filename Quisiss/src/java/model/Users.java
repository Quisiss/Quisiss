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
public class Users {
    private int userId;
    private String userName;
    private String password;
    private int classID;
    private String email;

    public Users() {
    }

    public Users(String userName, String password, String email) {
        
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    
    public Users(int userId, String userName, String password, int classID, String email) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.classID = classID;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Users{" + "userId=" + userId + ", userName=" + userName + ", password=" + password + ", classID=" + classID + ", email=" + email + '}';
    }
    
    
    
}
