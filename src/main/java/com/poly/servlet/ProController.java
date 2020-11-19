/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.servlet;

import com.poly.dao.ProductDao;
import com.poly.dao.UserDao;
import com.poly.model.Product;
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
public class ProController extends HttpServlet {

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
                   deletePro(request, response);
                    break;
                case "UPDATE":
                    int id = Integer.parseInt(request.getParameter("proid"));
                    response.sendRedirect("Admin/Update_Product.jsp?_type=" + type + "&id=" + id);
                    break;
                case "INSERT":
                    insertPro(request, response);
                    break;
                case "EXE_UPDATE":
                    updatePro(request, response);
                    break;

            }
        
        }
    }
    private void insertPro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao proDao = new ProductDao();
        Product pro = new Product();
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price")); 
        String note = request.getParameter("note");
        String image=request.getParameter("image");
        int category_id = Integer.parseInt(request.getParameter("category_id"));          
        pro.setName(name);
        pro.setPrice(price);
        pro.setNote(note);
        pro.setImage(image);
        pro.setCategory_id(category_id);
        proDao.insertPro(pro);
        response.sendRedirect("Admin/Show_Product.jsp");

    }
     private void deletePro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("proid"));
        ProductDao userDao = new ProductDao();
        boolean result = userDao.deletePro(id);
         response.sendRedirect("Admin/Show_Product.jsp");
    }
     
    private void updatePro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        String note = request.getParameter("note");
        String image = request.getParameter("image");
        int category_id  = Integer.parseInt(request.getParameter("category_id"));
        Product pro = new Product(id, name, price, note, image, category_id);
        ProductDao use = new ProductDao();
        boolean result=use.updatePro(pro);
        if (use.updatePro(pro)) {
            request.getSession().setAttribute("message", "Cập Nhật Thành Công");
            request.getSession().setAttribute("status", "Success");

        } else {
            request.getSession().setAttribute("message", "Cập Nhật Thất Bại");
            request.getSession().setAttribute("status", "Danger");
        }
        response.sendRedirect("Admin/Show_Product.jsp?id="+id);
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
