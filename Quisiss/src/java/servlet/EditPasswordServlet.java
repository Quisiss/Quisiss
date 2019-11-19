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
public class EditPasswordServlet extends HttpServlet {

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
        String username = request.getParameter("username");
        String cfpassword = request.getParameter("cfpassword");
        String password = request.getParameter("password");
        String msg = null;

        if (cfpassword.trim().isEmpty() || password.trim().isEmpty()) {
            msg = "Please Insert Your Info";
            request.setAttribute("msg", msg);
            getServletContext().getRequestDispatcher("/WEB-INF/views/EditProfile.jsp").forward(request, response);
        }

        UsersController usc = new UsersController();
        Users u = usc.findUsersByUsername(username);
        Users u2 = (Users) request.getSession().getAttribute("user");

        if (u != null) {

//            if (username.equals(u.getUserName())) {
        } else {
            if (password.equals(u2.getPassword())) {
                msg = "New Password Cannot Same Current Password !!!";
                request.setAttribute("msg", msg);
                getServletContext().getRequestDispatcher("/WEB-INF/views/EditProfile.jsp").forward(request, response);
            } else {
                if (cfpassword.equals(password)) {
                    u2.setPassword(password);
                    usc.setPassword(u2);
                    msg = "Update Password Complete";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher("/WEB-INF/views/EditProfile.jsp").forward(request, response);
                }else{
                    msg = "Password Not Same !!!";
                    request.setAttribute("msg", msg);
                    getServletContext().getRequestDispatcher("/WEB-INF/views/EditProfile.jsp").forward(request, response);
                }

            }
        }

        msg = "Cannot Update Password";
        request.setAttribute("msg", msg);
        getServletContext().getRequestDispatcher("/WEB-INF/views/EditProfile.jsp").forward(request, response);
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
        getServletContext().getRequestDispatcher("/WEB-INF/views/EditProfile.jsp").forward(request, response);
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
