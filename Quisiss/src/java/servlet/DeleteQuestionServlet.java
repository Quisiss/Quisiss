/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Classroom;
import model.Question;
import model.Quiz;
import model.controller.classController;
import model.controller.questionController;
import model.controller.quizController;

/**
 *
 * @author Lenovo-Y50
 */
public class DeleteQuestionServlet extends HttpServlet {

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
        System.out.println("test");
        System.out.println("5555");
        String preClassId = request.getParameter("classId");
        System.out.println(preClassId);
        int classId = Integer.parseInt(preClassId);
        System.out.println(classId);
        String preQuizId = request.getParameter("quizId");
        System.out.println(preQuizId);
        int quizId = Integer.parseInt(preQuizId);
        System.out.println(quizId);
        String preQuesId = request.getParameter("questionId");
        System.out.println(preQuesId);
        int quesId = Integer.parseInt(preQuesId);
        System.out.println(quesId);
        questionController qc = new questionController();
        qc.deleteQuestionById(classId, quizId, quesId);
        quizController quizC = new quizController();
        classController c = new classController();
        System.out.println("666666");
        getServletContext().getRequestDispatcher("/CreateQuestion").forward(request, response);
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
