<%-- 
    Document   : Show_User
    Created on : Feb 9, 2020, 8:10:21 PM
    Author     : Thanh Hau
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.poly.model.User"%>
<%@page import="com.poly.dao.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nhân Sự</title>
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
                <td width="78%">
                    <!--Phần Nội Dung------>
                    <h1>Danh Sách Tài Khoản</h1>
                    <table  width="100%" border="1" style="text-align: center;">
                        <tr style="background-color:skyblue" >
                            <td>ID</td>
                            <td>UserName</td>
                            <td>Password</td>
                            <td>Fullname</td>
                            <td>Email</td>
                            <td>Phone</td>
                            <td>Role</td>
                            <td>Delete</td>
                            <td>Update</td>
                        </tr>
                        <%  UserDao user = new UserDao();
                            ArrayList<User> dsUser = user.fillAll();
                            for (int i = 0; i < dsUser.size(); i++) {%>
                        <tr>
                            <td><%= dsUser.get(i).getId()%></td>
                            <td><%= dsUser.get(i).getUsername()%></td>
                            <td><%= dsUser.get(i).getPassword()%></td>
                            <td><%= dsUser.get(i).getFullname()%></td>
                            <td><%= dsUser.get(i).getEmail()%></td>
                            <td><%= dsUser.get(i).getPhone()%></td>
                            <td><%= dsUser.get(i).getRole()%></td>
                        <form method="get" action="../UserController">
                            <td><input style="background-color: red;color: white;" type="submit" name="_type" value="DELETE" ></input></td>
                            <td><input style="background-color: chartreuse;color: white;" type="submit" name="_type" value="UPDATE"></input></td>
                            <td><input type="hidden" name="userid" value="<%= dsUser.get(i).getId()%>"></input></td>                                         
                        </form>
            </tr>
            <%}%>
        </table>
        <!--------Kết thúc Phần nội Dung----------->
    </td>
</tr>
</table>

</body>
</html>
