<%-- 
    Document   : Logout
    Created on : Feb 19, 2020, 7:31:14 PM
    Author     : Thanh Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Xuất</title>
    </head>
    <body>
        <h1>Đăng Xuất</h1>
          <%
            session.setAttribute("userLogined", null);
            response.sendRedirect(request.getContextPath()+"/Login.jsp");
            
        %>
    </body>
</html>
