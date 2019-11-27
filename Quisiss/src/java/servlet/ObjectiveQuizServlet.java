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
import model.Users;
import model.controller.ChoiceController;
import model.controller.UsersController;
import model.controller.classController;
import model.controller.questionController;
import model.controller.quizController;

/**
 *
 * @author Lenovo-Y50
 */
public class ObjectiveQuizServlet extends HttpServlet {

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
        String preClassId = request.getParameter("classId");
        String preQuizId = request.getParameter("quizId");
        int classId = Integer.parseInt(preClassId);
        int quizId = Integer.parseInt(preQuizId);
        // Users u = (Users) session.getAttribute("user");
        UsersController uc = new UsersController();
        classController cc = new classController();
        quizController qc = new quizController();
        questionController quesc = new questionController();
        ChoiceController choicec = new ChoiceController();
        Users u = uc.findUsersById(1);
        Classroom c = cc.getClassroomById(classId);
        Quiz q = qc.getQuizById(c, quizId);
        ArrayList<Question> questions = quesc.getQuestionByQuizId(classId, quizId);
        if (questions != null) {
            request.setAttribute("questions", questions);
        }
        ArrayList<Choice> choices = choicec.getChoiceByQuizId(q);
        if (choices != null) {
            request.setAttribute("choices", choices);
        }
        request.setAttribute("quiz", q);
        request.setAttribute("class", c);
        System.out.println(questions);
        System.out.println(choices);
        getServletContext().getRequestDispatcher("/WEB-INF/views/ObjectiveQuiz.jsp").forward(request, response);
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
