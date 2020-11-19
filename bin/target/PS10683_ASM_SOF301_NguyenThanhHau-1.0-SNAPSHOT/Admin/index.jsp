<%-- 
    Document   : index
    Created on : Feb 18, 2020, 4:10:53 PM
    Author     : Thanh Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Chủ</title>
    </head>
    <body>
        <table width="100%" border="1">
            <tr>
                <td colspan="2">
                    <%@include file="/Banner.jsp" %>

                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <%@include file="/TopMenu.jsp" %>

                </td>
            </tr>
            <tr>
                <td width="22%"><%@include file="../Admin/LeftMenu.jsp" %></td>
                <td width="78%" style="background: floralwhite">
                    <p style="text-align: center; color:red; font-size:25px; ">CÁC SẢN PHẨM VÀ HÌNH SẼ LOAD Ở ĐÂY</p><br>
                    <p style="text-align: center">SHOP NOW</p>
                </td>
            </tr>
        </table>
    </body>
</html>
