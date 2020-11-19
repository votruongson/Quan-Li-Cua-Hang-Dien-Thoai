<%-- 
    Document   : TopMenu
    Created on : Feb 18, 2020, 3:32:09 PM
    Author     : Thanh Hau
--%>

<%@page import="com.poly.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       
    </head>
    <body>
          <img src="../Hinh/manu.jpg" style="width: 100%; height: 190px"/>
        <a href="<%= request.getContextPath()%>/Admin/index.jsp">Trang chủ</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
        <a href="<%= request.getContextPath()%>/Admin/Show_Cart.jsp">Giỏ hàng</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
         <%
            User user1 = (User) session.getAttribute("userLogined");
            if (user1 == null) {%> 
        <a href="<%= request.getContextPath()%>/Login.jsp">Đăng nhâp</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="<%= request.getContextPath()%>/register.jsp">Đăng kí</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <%} else {%>
        <a href="<%= request.getContextPath()%>/Logout.jsp">Đăng xuất</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <% } %>       
    </body>
</html>
