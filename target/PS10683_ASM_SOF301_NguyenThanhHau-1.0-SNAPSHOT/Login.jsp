<%-- 
    Document   : Login
    Created on : Feb 18, 2020, 4:38:02 PM
    Author     : Thanh Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Nhập</title>
        <link rel="stylesheet" href="Login.css">
    </head>
    <body>
        <div class="Container">
            <form action="LoginController" method="get"> 
                <h1 style="text-align: center;">LOGIN</h1>
                <input class="form-control" type="text" name="username" value=""/><br/>
                <input class="form-control" type="text" name="password" value=""/><br>
                <input class="form-check-input" type="checkbox" />REMEMBER ME  &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                <a class="forgot" href="#">Reset Password</a><br><br>
                <button class="btn" type="submit" name="btn" value="submit">Sign Up</button><br>
                <%
                    String message = request.getParameter("message");
                    if (message != null) {
                        out.print(message);
                    }
                %>
                <p style="text-align: center;">or Sign in with<br>
                    <img src="Hinh/icons8-facebook-circled-48.png"/>
                    <img src="Hinh/icons8-gmail-48.png"/>
                    <img src="Hinh/icons8-twitter-48.png"/></p>
                <hr>
                <p style="text-align: center;">Do not have an account? &nbsp;<a href="#"> Sign Up Here</a></p>

            </form>
        </div>
</body>
</html>
