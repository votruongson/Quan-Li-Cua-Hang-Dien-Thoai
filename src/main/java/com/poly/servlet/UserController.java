/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.servlet;

import com.poly.dao.UserDao;
import com.poly.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thanh Hau
 */
public class UserController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String type = request.getParameter("_type");
            System.out.println(type);
            switch (type) {
                case "DELETE":
                    deleteUser(request, response);
                    break;
                case "UPDATE":
                    int id = Integer.parseInt(request.getParameter("userid"));
                    response.sendRedirect("Admin/Update_User.jsp?_type=" + type + "&id=" + id);
                    break;
                case "INSERT":
                    insertUser(request, response);
                    break;
                case "EXE_UPDATE":
                    updateUser(request, response);
                    break;

            }
        }
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int role = Integer.parseInt(request.getParameter("role"));
        user.setUsername(username);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setRole(role);
//        userDao.insertUser(user);
        if (userDao.insertUser(user)) {
            request.getSession().setAttribute("message", "Thêm Thành Công");
            response.sendRedirect("Admin/Show_User.jsp");
            request.getSession().setAttribute("status", "Success");

        } else {
            request.getSession().setAttribute("message", "Thêm Thất Bại");
            request.getSession().setAttribute("status", "Danger");
        }

    }
    

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("userid"));
        UserDao userDao = new UserDao();
        boolean result = userDao.deleteUser(id);
        response.sendRedirect("Admin/Show_User.jsp");
    }

   private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        int role = Integer.parseInt(request.getParameter("role"));
        User user = new User(id, username, password, fullname, email, phone, role);
        UserDao use = new UserDao();
        boolean result = use.updateUser(user);
        if (use.updateUser(user)) {
            request.getSession().setAttribute("message", "Cập Nhật Thành Công");
            request.getSession().setAttribute("status", "Success");

        } else {
            request.getSession().setAttribute("message", "Cập Nhật Thất Bại");
            request.getSession().setAttribute("status", "Danger");
        }
        response.sendRedirect("Admin/Show_User.jsp?id=" + id);

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
