package model.controller;

import database.BuildConnection;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
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
                Classroom c = new Classroom(rs.getInt("classId"),rs.getString("className"),rs.getString("classCode"),rs.getInt("ownerId"),rs.getInt("userId"));
                arr.add(c);
            }
            conn.close();
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Classroom getClassroomByCode(String classCode){
        ArrayList<Classroom> arr = new ArrayList();
        try{
            conn = BuildConnection.getConnection();
            Classroom classroom = null;
            PreparedStatement ps = conn.prepareStatement("select * from classroom where classcode = ? and userid is null");
            ps.setString(1, classCode);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Classroom c = new Classroom(rs.getInt("classId"),rs.getString("className"),rs.getString("classCode"),rs.getInt("ownerId"),rs.getInt("userId"));
                classroom = c;
            }
            conn.close();
            return classroom;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void deleteClassById(int classid){
        try{
            quizController qc = new quizController();
            classController cc = new classController();
            questionController quc = new questionController();
            ChoiceController choicec = new ChoiceController();
            conn = BuildConnection.getConnection();
            PreparedStatement ps1 = conn.prepareStatement("delete from classroom where classid = ?");
            ps1.setInt(1, classid);
            ps1.executeUpdate();
            ArrayList<Classroom> classes = cc.getAllClassroom();
            for (int i = classid; i <= classes.size(); i++) {
                PreparedStatement ps2 = conn.prepareStatement("UPDATE classroom SET classid = ? WHERE classid = ?");
                ps2.setInt(1, i);
                ps2.setInt(2, i+1);
                ps2.executeUpdate();
            }
            qc.deleteQuizByClassId(classid);
            quc.deleteQuestionByClassId(classid);
            choicec.deleteChoiceByClassId(classid);
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public String getRandomCode(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 6;
        Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int) 
                  (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }  
            String classcode = buffer.toString();
            return classcode;
    }
    
    public void createNewClassroom(String className,int ownerId){
        try{
            classController cc = new classController();
            String statement =  "insert into classroom(classid,classname,classcode,ownerid) values (?,?,?,?)";
            int classid = cc.getNewClassId();
            String classcode = null;
            String preclasscode = cc.getRandomCode();
            ArrayList<Classroom> c = cc.getAllClassroom();
            for(int i=0;i<c.size();i++){
                if(c.get(i).getClassCode()== preclasscode){
                    preclasscode = cc.getRandomCode();
                    i--;
                }
             }
            classcode = preclasscode;
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(statement);
            ps.setInt(1, classid);
            ps.setString(2, className);
            ps.setString(3, classcode);
            ps.setInt(4, ownerId);
            ps.executeUpdate();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Users> getUsersByClassId(int id){
        ArrayList<Users> users = new ArrayList<Users>();
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select userid from classroom where classid = ? and userid is not null");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt("userid");
                PreparedStatement ps1 = conn.prepareStatement("select * from users where userid = ?");
                ps1.setInt(1, userId);
                ResultSet rs1 = ps1.executeQuery();
                while(rs1.next()){
                    Users u = new Users(rs1.getInt("userid"), rs1.getString("username"), rs1.getString("password"), rs1.getString("email"));
                    users.add(u);
                }  
            }
//            System.out.println(users);
//            for(int i=0;i<users.size();i++){
//                System.out.println(users.get(i).getUserName());
//            }
            return users;
        } catch (SQLException ex) {
            Logger.getLogger(classController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    
    public ArrayList<Classroom> getClassroomByOwnerId(int id){
        ArrayList<Classroom> classes = new ArrayList();
        try{
            conn = BuildConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from classroom where ownerid = ? and userid is null");
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
        //Classroom c = new Classroom(2,"test","a1a2a3",2);
        classController cc = new classController();
        UsersController uc = new UsersController();
        Users u = uc.findUsersById(2);
        //System.out.println(cc.getNewClassId());
        //Users u = new Users(10,"cheer","test","asdad");
        Classroom c = cc.getClassroomById(1);
//        System.out.println(c.getOwnerId());
//        System.out.println(c.getClassId());
//        System.out.println(c.getClassName());
        ArrayList<Classroom> c1 = cc.getAllClassroom();
       for(int i=0;i<c1.size();i++){
           //System.out.println(c1.get(i).getClassName()+c1.get(i).getClassCode());
        }
       cc.getUsersByClassId(9);
       //cc.deleteClassById(2);
       //cc.addUserIntoClassroom(c, u);
        //cc.createNewClassroom("testclass", 10);
        //cc.deleteClassById(1);
    }
}
