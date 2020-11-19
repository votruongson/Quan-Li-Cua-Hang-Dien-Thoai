<%-- 
    Document   : LeftMenu
    Created on : Feb 18, 2020, 3:35:57 PM
    Author     : Thanh Hau
--%>

<%@page import="com.poly.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            h1{
                color: red;
                 
            }
            h3{
                color: blue;
                   
            }
            a{
                text-align: center;
            }
         
          
        </style>
    </head>
    <body>
        <h1><%
            User user2 = (User) session.getAttribute("userLogined");
            if (user2 != null) {
                out.print("Chào: " + user2.getUsername());
            } else {
                response.sendRedirect(request.getContextPath() + "/Login.jsp");
            }

            %></h1>
        <h3 style>Quản Lí Tài Khoản</h3>
        <a  href="Show_User.jsp">Xem người dùng</a><br>
        <a href="add_User.jsp">Thêm người dùng</a><br>
        <hr>
        <h3>Quản Lí Sản Phẩm</h3>
        <a href="Show_Product.jsp">Xem sản phẩm</a><br>
        <a href="add_Product.jsp">Thêm sản phẩm</a>
    </body>
</html>
