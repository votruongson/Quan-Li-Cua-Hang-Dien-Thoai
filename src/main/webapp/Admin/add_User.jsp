<%-- 
    Document   : add_User
    Created on : Feb 9, 2020, 8:23:02 PM
    Author     : Thanh Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Nhân Sự</title>
        <style>
            .form-control{
                display: block;
                width: 100%;
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
                <td width="78%">
                    <!--Phần Nội Dung---->
                    <h1>Thêm Tài Khoản</h1>
                    <form  method="get" action="../UserController">                       
                        <label>UserName:</label> <input class="form-control" type="text" name="username"></input><br>
                        <label>Password:</label> <input class="form-control" type="text" name="password"></input><br>
                        <label>FullName:</label> <input class="form-control" type="text" name="fullname" required="required" ></input><br>
                        <label>Email:</label> <input class="form-control" type="text" name="email"></input><br>
                        <label>Phone:</label> <input class="form-control" type="text" name="phone"></input><br>
                        <label>Role: </label><input type="radio" name="role1" value="1">Admin</input>
                        <input type="radio" name="role"0 value="0">User</input><br><br>
                        <input style="background-color: blue;color: white;" type="submit" name="_type" class="submit" value="INSERT" ></input>
                    </form>
                    <!--Kết Thúc Nội Dung--->
                </td>
            </tr>
        </table>

    </body>
</html>
