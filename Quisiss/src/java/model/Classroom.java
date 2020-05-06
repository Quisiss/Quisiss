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
public class Classroom {
    private int classId;
    private String className;
    private String classCode;
    private int ownerId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Classroom(int classId, String className, String classCode, int ownerId) {
        this.classId = classId;
        this.className = className;
        this.classCode = classCode;
        this.ownerId = ownerId;
    }

    public Classroom(int classId, String className, String classCode, int ownerId, int userId) {
        this.classId = classId;
        this.className = className;
        this.classCode = classCode;
        this.ownerId = ownerId;
        this.userId = userId;
    }
    
    

    public Classroom() {
        
    }
    
    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
    
}
