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
import model.Choice;
import model.Classroom;
import model.Question;
import model.Quiz;
import model.controller.ChoiceController;
import model.controller.questionController;

/**
 *
 * @author Lenovo-Y50
 */
public class CreateQuestionServlet extends HttpServlet {

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
        questionController qc = new questionController();
        ChoiceController cc = new ChoiceController();
        Classroom c = (Classroom) request.getAttribute("class");
        if (c == null) {
            c = (Classroom) session.getAttribute("class");
        }
        Quiz q = (Quiz) request.getAttribute("quiz");
        if (q == null) {
            q = (Quiz) session.getAttribute("quiz");
        }
        
        session.setAttribute("class", c);
        session.setAttribute("quiz", q);
        String answer = request.getParameter("answer");
        String question = (String) request.getParameter("question");
        
        ArrayList<Question> questions = qc.getQuestionByQuizId(c.getClassId(), q.getQuizId());
        if (questions != null) {
            request.setAttribute("questions", questions);
        }
        ArrayList<Choice> choices = cc.getChoiceByQuizId(q);
        if (choices != null) {
            request.setAttribute("choices", choices);
        }
        if (question != null) {
            qc.createNewQuestion(q.getQuizId(), question, answer, c.getClassId());
            questions = qc.getQuestionByQuizId(c.getClassId(), q.getQuizId());
            Question ques = qc.getQuestionById(q, qc.getNewQuestionId(q.getQuizId(), c.getClassId()) - 1);
            request.setAttribute("questions", questions);
            String quesId = Integer.toString(ques.getQuestionid());
            choices = cc.getChoiceByQuizId(q);
            if (choices != null) {
                request.setAttribute("choices", choices);
            }
            int max = 5;
            for (int i = 1; i < max; i++) {
                String num = Integer.toString(i);
                String choice = request.getParameter("choice" + num);
                if (choice != null) {
                    cc.addNewChoice(ques, num, choice);
                }
                if (choice == null) {
                    i = 5;
                }
            }
            response.sendRedirect("CreateQuestion");
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/CreateQuiz.jsp").forward(request, response);
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
