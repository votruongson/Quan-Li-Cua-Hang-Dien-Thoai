<%-- 
    Document   : Update_Product
    Created on : Feb 25, 2020, 1:11:24 PM
    Author     : Thanh Hau
--%>

<%@page import="com.poly.model.Product"%>
<%@page import="com.poly.dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập Nhật Sản Phẩm</title>
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
                <td width="78%">
                    <!---Phần Nội Dung---->
                    <%  int id = Integer.parseInt(request.getParameter("id"));
                        ProductDao dao = new ProductDao();
                        Product pro = dao.findById(id);
                    %>
                    <h1>Cập Nhật Sản Phẩm</h1>
                    <form  action="../ProController"  method="get">
                        ID:<%= pro.getId()%><br>          
                        Name: <input class="form-control" type="text" name="name" value="<%= pro.getName()%>"></input><br>
                        Price: <input class="form-control" type="text" name="price" value="<%= pro.getPrice()%>"></input><br>
                        Note: <input class="form-control" type="text" name="note" value="<%= pro.getNote()%>" ></input><br>
                        Image: <input class="form-control" type="text" name="image" value="<%= pro.getImage()%>"></input><br>
                        Category_id: <input class="form-control" type="text" name="category_id" value="<%= pro.getCategory_id()%>"></input><br>
                        <input type="submit" name="_type" value="EXE_UPDATE" ></input>
                        <input type="hidden" name="id" value="<%=pro.getId()%>"></input><br>
                    </form>
                    <!---Kết Thúc Nội Dung----->
                </td>
            </tr>
        </table>
    </body>
</html>
