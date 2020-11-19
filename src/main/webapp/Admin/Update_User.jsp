<%-- 
    Document   : Update_User
    Created on : Feb 25, 2020, 3:28:13 PM
    Author     : Thanh Hau
--%>

<%@page import="com.poly.model.User"%>
<%@page import="com.poly.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập Nhật Nhân Sự</title>
                <style>
            .form-control{
                display: block;
                width: 99%;
                height: 20px;
                padding: 5px;
                font-size: 1rem;
                font-weight: 400;
                line-height: 1.5;
                color: #495057;
                background-color: #fff;
                border: 1px solid #ced4da;
                border-radius: .25rem;
                transition: border-color .15s ease-in-out,box-shadow .15s ease-in-out;
            }
           
        </style>
    </head>
    <body>
        <table width="100%" border="1">
            <tr>
                <td colspan="2">
                    <%@ include file="/Banner.jsp" %>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <%@ include file="/TopMenu.jsp" %>
                </td>
            </tr>
            <tr>
                <td width="22%"><%@ include file="/Admin/LeftMenu.jsp" %></td>
                <!--Phần Nội Dung -->
                <td width="78%">
                    <%            int id = Integer.parseInt(request.getParameter("id"));
                        UserDao dao = new UserDao();
                        User user = dao.findById(id);

                    %>
                    <h1>Update User</h1>
                    <form action="../UserController" method="get">
                        ID: <%= user.getId()%> <br>
                        Username: <input class="form-control" type="text" name="username" value="<%= user.getUsername()%>"></input><br>
                        Password: <input class="form-control" type="text" name="password" value="<%= user.getPassword()%>"></input><br>
                        Fullname: <input class="form-control" type="text" name="fullname" value="<%= user.getFullname()%>"></input><br>
                        Email: <input class="form-control" type="text" name="email" value="<%= user.getEmail()%>"></input><br>
                        Phone: <input class="form-control" type="text" name="phone" value="<%= user.getPhone()%>"></input><br>
                        <% int role = user.getRole(); %>
                                     Role: <input type="radio" name="role" value="1" <% if (role == 1) {
                    out.print("checked");
                } %> >Admin</input>
                               <input type="radio" name="role" value="0" <% if (role == 0) {
                    out.print("checked");
                }%> >User</input><br>
                        <input type="hidden" name="id" value="<%= user.getId()%>"></input><br>
                        <input type="submit"  name="_type" value="EXE_UPDATE"></input>
                    </form>
                </td>
                <!--Phần kết thúc nội dung -->
            </tr>
        </table>
    </body>
</html>
