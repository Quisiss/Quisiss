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
import model.Users;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo-Y50
 */
public class classController {
    Connection conn = null;
    
    public ArrayList<Classroom> getAllClassroom(){
        ArrayList<Classroom> arr = new ArrayList();
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from classroom");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Classroom c = new Classroom(rs.getInt("classId"),rs.getString("className"),rs.getString("classCode"),rs.getInt("ownerId"));
                arr.add(c);
            }
            conn.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int getNewClassId(){
        int id=0;
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select max(classid) from classroom");
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                id = rs.getInt(1);
            }
            rs.close();
            conn.close();
            return id+1;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id+1;
    }
    
    public void createNewClassroom(String className,int ownerId){
        classController cc = new classController();
        int classid = cc.getNewClassId();
    }
    
    public Classroom getClassroomById(int id){
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from classroom where classid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               return new Classroom(rs.getInt("classId"),rs.getString("className"),rs.getString("classCode"),rs.getInt("ownerId"));
            }
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Classroom> getClassroomByUserId(int id){
        ArrayList<Classroom> classes = new ArrayList();
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from classroom where userid = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Classroom c = new Classroom(rs.getInt("classId"),rs.getString("className"),rs.getString("classCode"),rs.getInt("ownerId"));
                classes.add(c);
            }
           return classes;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void addUserIntoClassroom(Classroom c,Users u){
        try{
            conn = BuildConnection.getConnection();
            String add = "insert into classroom(classid,classname,classcode,ownerid,userid) values "
                        + " (?,?,?,?,?) ";
            PreparedStatement ps = conn.prepareStatement(add);
            {
                ps.setInt(1, c.getClassId());
                ps.setString(2, c.getClassName());
                ps.setString(3, c.getClassCode());
                ps.setInt(4, c.getOwnerId());
                ps.setInt(5, u.getUserId());
                ps.executeUpdate();
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public static void main(String[] args) {
        Classroom c = new Classroom(1,"test","a1a2a3",2);
        classController cc = new classController();
        System.out.println(cc.getNewClassId());
        Users u = new Users(50,"cheer","test",1,"asdad");
        //Classroom c = cc.getClassroomById(1);
        System.out.println(c.getOwnerId());
        System.out.println(c.getClassId());
        System.out.println(c.getClassName());
        ArrayList<Classroom> c1 = cc.getAllClassroom();
       for(int i=0;i<c1.size();i++){
           System.out.println(c1.get(i).getClassName()+c1.get(i).getClassCode());
        }
        System.out.println(cc.getNewClassId());
        cc.addUserIntoClassroom(c, u);
    }
}
