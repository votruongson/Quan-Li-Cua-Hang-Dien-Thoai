<%-- 
    Document   : Show_Product
    Created on : Feb 15, 2020, 2:41:10 PM
    Author     : Thanh Hau
--%>

<%@page import="java.util.List"%>
<%@page import="com.poly.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.poly.dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sản Phẩm</title>
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
                    <!----Phần Nội Dung----->

                    <h1>Danh Sách Sản Phẩm</h1>
                    <table width="100%" border="1" style="text-align: center;">
                        <tr style="background-color:skyblue">
                            <td>ID</td>
                            <td>Name</td>
                            <td>Price</td>
                            <td>Note</td>
                            <td>Image</td>
                            <td>Category_id</td>
                            <td>Delete</td>
                            <td>Update</td>
                            <td>Add To Cart</td>
                        </tr>
                        <%  ProductDao pro = new ProductDao();
                            ArrayList<Product> dsPro = pro.fillAll();
                            for (int i = 0; i < dsPro.size(); i++) {%>
                        <tr>
                            <td><%= dsPro.get(i).getId()%></td>
                            <td><%= dsPro.get(i).getName()%></td>
                            <td><%= dsPro.get(i).getPrice()%></td>
                            <td><%= dsPro.get(i).getNote()%></td>
                            <td>
                                <img src="../Image/<%= dsPro.get(i).getImage()%>" width="180" height="180"/></td>
                            <td>

                                <%= pro.getCategoryByID(dsPro.get(i).getCategory_id())%>
                            </td>

                        <form method="get" action="../ProController">
                            <td><input style="background-color: red;color: white;" type="submit" name="_type" value="DELETE" ></input></td>
                            <td><input style="background-color: chartreuse;color: white;" type="submit" name="_type" value="UPDATE" ></input></td>
                            <input type="hidden" name="proid" value="<%= dsPro.get(i).getId()%>">                                          
                        </form>
                        <form action="../CartController">
                            <input type="hidden" name="id" value="<%= dsPro.get(i).getId()%>"> 
                            <input type="hidden" name="name" value="<%= dsPro.get(i).getName()%>"> 
                            <input type="hidden" name="price" value="<%= dsPro.get(i).getPrice()%>"> 
                            <input type="hidden" name="note" value="<%= dsPro.get(i).getNote()%>"> 
                            <input type="hidden" name="image" value="<%= dsPro.get(i).getImage()%>"> 
                            <input type="hidden" name="category_id" value="<%= dsPro.get(i).getCategory_id()%>"> 
                            <td><input style="background-color: blue;color: white;" type="submit" name="action" value="Add to Cart"></input></td>   
                        </form>
            </tr>
        </form>
        <!---Kết Thúc Nội Dung---->
        <%}%>
    </table>
</td>
</tr>
</table>
</body>
</html>
