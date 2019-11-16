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
import model.Users;
import model.controller.UsersController;

/**
 *
 * @author Acer Nitro
 */
public class RegisterServlet extends HttpServlet {

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
        
        String userid = request.getParameter("id");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String passwordrepeat = request.getParameter("passwordrepeat");
        String classid = request.getParameter("classid");
        String msg = null;
        
        
        if(email.trim().isEmpty()||username.trim().isEmpty()||password.trim().isEmpty()||passwordrepeat.trim().isEmpty()){
            msg = "Please Insert Info";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
        }
        
        int uid = Integer.valueOf(userid);
        int cid = Integer.valueOf(classid);
        UsersController usc = new UsersController();
        Users u = usc.findUsersById(uid);
        
        if(passwordrepeat!=password){
            msg = "Your repeat password is not same your password !!!";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
        }
        
        if(u!=null){
            msg = "This username already exist!!!";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
        }else{
            Users newu = new Users(uid, username, password, cid, email);
            usc.addUser(newu);
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
        }
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
