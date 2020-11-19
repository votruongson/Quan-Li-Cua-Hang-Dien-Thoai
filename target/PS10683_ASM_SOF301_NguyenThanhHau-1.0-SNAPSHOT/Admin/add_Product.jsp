<%-- 
    Document   : add_Product
    Created on : Feb 15, 2020, 3:25:07 PM
    Author     : Thanh Hau
--%>

<%@page import="com.poly.model.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poly.dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Sản Phẩm</title>
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
                    <!--Phần Nội Dung---->
                    <h1>Thêm Sản Phẩm</h1>
                    <form action = "UploadFile.jsp" method = "post"
                          enctype = "multipart/form-data">
                        <input type = "file" name = "file" size = "50" />
                        <br />
                        <br>
                        <input type = "submit" value = "Upload File" />
                    </form>
                    <%
                        String filename = request.getParameter("filename");
                        if (filename != null) {
                            out.print("Upload Thành Công");
                        }
                    %>
                    <form  method="get" action="../ProController">
                        Name: <input class="form-control" type="text" name="name"></input><br>
                        Price: <input class="form-control" type="text" name="price"></input><br>
                        Note: <input class="form-control" type="text" name="note"></input><br>
                        Image: <input class="form-control" type="text" name="image" value="<%= filename%>"></input><br>
                        Category:<select name="category_id">
                            <%
                                ProductDao dao = new ProductDao();
                                ArrayList<Category> ct = dao.fillAllCategories();
                                for (int i = 0; i < ct.size(); i++) {
                                    out.print("<Option value=" + ct.get(i).getId() + ">" + ct.get(i).getName() + ">" + ct.get(i).getNote());
                                }
                            %>
                        </select><br>
                        <br><input style="background-color: blue;color: white;"  type="submit" name="_type" value="INSERT" ></input>
                    </form>
                </td>
                <!--Kết Thúc Nội Dung---->
            </tr>
        </table>

    </body>
</html>
