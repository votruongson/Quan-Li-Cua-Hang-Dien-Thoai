/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poly.servlet;

import com.poly.dao.ProductDTO;
import com.poly.model.CartBean;
import com.poly.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Thanh Hau
 */
public class CartController extends HttpServlet {

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
            String action = request.getParameter("action");
            switch (action) {
                case "Add to Cart": {
                    HttpSession session = request.getSession(true);
                    CartBean shop = (CartBean) session.getAttribute("SHOP");
                    if (shop == null) {
                        shop = new CartBean();
                    }
                    int id = Integer.parseInt(request.getParameter("id"));
                    String name = request.getParameter("name");
                    int price = Integer.parseInt(request.getParameter("price"));
                    String note = request.getParameter("note");
                    String image = request.getParameter("image");
                    int category_id = Integer.parseInt(request.getParameter("category_id"));
                    Product pro = new Product(id, name, price, note, image, category_id);
                    ProductDTO use = new ProductDTO(pro);
                    shop.addSanPham(use);
                    session.setAttribute("SHOP", shop);
                    RequestDispatcher rd = request.getRequestDispatcher("Admin/Show_Cart.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "View Cart": {
                    RequestDispatcher rd = request.getRequestDispatcher("Admin/Show_Cart.jsp");
                    rd.forward(request, response);
                    break;
                }
                case "Add More": {
                    response.sendRedirect("Admin/Show_Product.jsp");
                    break;
                }
                case "Remove": {
                    String[] list = request.getParameterValues("rmv");
                    if (list != null) {
                        HttpSession session = request.getSession();
                        if (session != null) {
                            CartBean shop = (CartBean) session.getAttribute("SHOP");
                            if (shop != null) {
                                for (int i = 0; i < list.length; i++) {
                                    shop.removeSanPham(list[i]);
                                }
                                session.setAttribute("SHOP", shop);
 
                            }
                        }
                    }
                    String url = "CartController?action=View Cart";
                    RequestDispatcher rd = request.getRequestDispatcher(url);
                    rd.forward(request, response);
                    break;
            }
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
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
            throws ServletException, IOException, NumberFormatException {
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
            throws ServletException, IOException, NumberFormatException {
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
