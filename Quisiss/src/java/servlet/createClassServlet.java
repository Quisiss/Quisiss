/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import database.BuildConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Classroom;
import model.Users;
import model.controller.UsersController;
import model.controller.classController;

/**
 *
 * @author Lenovo-Y50
 */
public class createClassServlet extends HttpServlet {
@PersistenceUnit(unitName = "QuisissPU")
EntityManagerFactory emf ;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersController uc = new UsersController();
        classController cc = new classController();
        System.out.println(request.getParameter("className"));
        String message = null;
        Users u = uc.findUsersById(1);
        request.setAttribute("user", u);
        ArrayList<Classroom> classes = cc.getClassroomByUserId(u.getUserId());
        if(classes != null){
            request.setAttribute("joinedclasses", classes);
        }
        String classCode = request.getParameter("classCode");
        if(classCode!=null){
            Classroom c = cc.getClassroomByCode(classCode);
            if(c!=null){
                ArrayList<Classroom> allclass = cc.getAllClassroom();
                for(int i=0;i<allclass.size();i++){
                    if(allclass.get(i).getUserId()==u.getUserId()){
                        message = "you already in this class";
                        request.setAttribute("message", message);
                        getServletContext().getRequestDispatcher("/WEB-INF/views/class.jsp").forward(request, response);
                        return;
                    }else{
                        if(i==allclass.size()-1){
                            cc.addUserIntoClassroom(c, u);
                        }
                    }
                } 
            }else{
                message = "invalid classcode " + classCode;
            }  
        }
        request.setAttribute("message", message);
        getServletContext().getRequestDispatcher("/WEB-INF/views/class.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}  
