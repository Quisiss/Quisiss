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
import model.Question;
import model.Quiz;
import model.Users;
import model.controller.UsersController;
import model.controller.questionController;

/**
 *
 * @author Acer Nitro
 */
public class SubjectiveQuizServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(600);
        Classroom c = (Classroom) request.getAttribute("class");
        Quiz quiz = (Quiz) request.getAttribute("quiz");
        if(c==null){
            c = (Classroom) session.getAttribute("class");
        }
        if(quiz==null){
            quiz = (Quiz) session.getAttribute("quiz");
        }
        session.setAttribute("class", c);
        session.setAttribute("quiz", quiz);
        System.out.println(c);
        System.out.println(quiz);
        String question = request.getParameter("question");
        if (question == null || quiz == null || c == null) {
            request.setAttribute("message", "Please enter question");
            getServletContext().getRequestDispatcher("/WEB-INF/views/SubjectiveQuiz.jsp").forward(request, response);
        }
        questionController qc = new questionController();
        Question q = new Question(quiz.getQuizId(), qc.getNewQuestionId(quiz.getQuizId(), quiz.getClassId()), question,quiz.getClassId());
        qc.createNewQuestion(quiz.getQuizId(), question, null, quiz.getClassId());
        System.out.println("createee");
        request.setAttribute("message", "CREATED!");
        getServletContext().getRequestDispatcher("/WEB-INF/views/SubjectiveQuiz.jsp").forward(request, response);

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
        //processRequest(request, response);
        getServletContext().getRequestDispatcher("/WEB-INF/views/SubjectiveQuiz.jsp").forward(request, response);
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
