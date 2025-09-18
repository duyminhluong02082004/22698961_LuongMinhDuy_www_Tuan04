<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css"
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<div class="container mt-4">
    <h3 class="text-center">Your Cart</h3>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>Photo</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Total</th>
            <th>Remove</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${cart}">
            <tr>
                <td>${item.product.name}</td>
                <td><img src="${pageContext.request.contextPath}/images/${item.product.image}" width="80"></td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.product.price * item.quantity}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/cart?action=remove&id=${item.product.id}"
                       class="btn btn-sm btn-danger">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
