<%-- 
    Document   : Show_Cart
    Created on : Feb 25, 2020, 9:54:12 AM
    Author     : Thanh Hau
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ Hàng</title>
    </head>
    <body>
        <h1>Your Shopping Cart!</h1>
        <c:set var="shop" value="${sessionScope.SHOP}"/>
        <c:if test="${not empty shop}">
            <table border="1">
                <thead>
                    <tr>
                        <td>No</td>
                        <td>ID</td>
                        <td>Name</td>
                        <td>Price</td>
                        <td>Note</td>
                        <td>Image</td>
                        <td>Category_id</td>
                        <td>Quantity</td>
                        <td>Action</td> 
                    </tr>
                </thead>
                <tbody>
                <form action="CartController">
                    <c:set var="count" value="0"/>
                    <c:forEach var="rows" items="${shop}">
                        <c:set var="count" value="${count+1}"/>                                        
                        <tr>
                            <td>${count}</td>
                            <td>${rows.value.sanpham.id}</td>     
                            <td>${rows.value.sanpham.name}</td>  
                            <td>${rows.value.sanpham.price}</td>  
                            <td>${rows.value.sanpham.note}</td>  
                            <td>${rows.value.sanpham.image}</td>  
                            <td>${rows.value.sanpham.category_id}</td>  
                            <td>${rows.value.quantity}</td>
                            <td><input type="Checkbox" name="rmv" value="${rows.value.sanpham.name}"/></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <c:url var="add" value="CartController">
                            <c:param name="action" value= "Add More"/>
                        </c:url>
                        <td colspan="2"><a href="${add}">Add More</a></td>
                        <td><input style="color: blue;" type="submit" value="Remove" name="action"/></td>
                    </tr>
                </form>
            </tbody>
        </table>
    </c:if>

</body>
</html>
