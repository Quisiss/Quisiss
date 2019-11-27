/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Classroom;
import model.Quiz;
import model.Users;
import model.controller.UsersController;
import model.controller.classController;
import model.controller.quizController;

/**
 *
 * @author Lenovo-Y50
 */
public class DoingQuizServlet extends HttpServlet {

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
        
        String preClassId = request.getParameter("classId");
        HttpSession session = request.getSession();
       // Users u = (Users) session.getAttribute("user");
        UsersController uc = new UsersController();
        Users u = uc.findUsersById(1);
        String message = null;
        int classId = Integer.parseInt(preClassId);
        classController cc = new classController();
        quizController qc = new quizController();
        Classroom c = cc.getClassroomById(classId);
        if(c!=null){
                ArrayList<Quiz> quizs = qc.getQuizByClassId(classId);
                if(quizs==null){
                    message = "no quiz yet";
                }   
                request.setAttribute("message", message);
                request.setAttribute("quizs", quizs);
                System.out.println("QUIZZZ : " + quizs.get(1).getType());
        }else{
                message = "not your class";
                request.setAttribute("message1", message);
                getServletContext().getRequestDispatcher("/createClassServlet").forward(request, response);                
                return;
        }
        System.out.println(c.getClassId());
        request.setAttribute("class", c);
        getServletContext().getRequestDispatcher("/WEB-INF/views/DoingQuiz.jsp").forward(request, response);
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
