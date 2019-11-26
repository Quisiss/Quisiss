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
import model.Question;
import model.Quiz;
import model.Users;
import model.controller.UsersController;
import model.controller.classController;
import model.controller.questionController;
import model.controller.quizController;

/**
 *
 * @author Acer Nitro
 */
public class ChoiceQuizServlet extends HttpServlet {

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
        
        String question = request.getParameter("question");
        String ans1 = request.getParameter("ans1");
        String ans2 = request.getParameter("ans2");
        String ans3 = request.getParameter("ans3");
        String ans4 = request.getParameter("ans4");
        String finalans = request.getParameter("finalans");
        String questionid = request.getParameter("questionid");
        String classid = request.getParameter("classid");
        String id = request.getParameter("id");
        String msg = null;
        
        if(question.trim().isEmpty()||ans1.trim().isEmpty()||ans2.trim().isEmpty()||ans3.trim().isEmpty()||ans4.trim().isEmpty()){
            msg = "Please Insert Question or Answer !!!";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher("/WEB-INF/views/ChoiceQuiz.jsp").forward(request, response);
        }
        
        int uid = Integer.valueOf(id);
        int cid = Integer.valueOf(classid);
        int qid = Integer.valueOf(questionid);
        UsersController uc = new UsersController();
        Users u = (Users) request.getSession().getAttribute("user");
        questionController qc = new questionController();
        ArrayList<Question> q = qc.getQuestionByQuizId(cid, uid);
        
        if(u!=null){
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/views/QuizChoice.jsp").forward(request, response);
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
