<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Product Page</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.2.3/css/bootstrap.min.css"
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>
        .table_center {
            margin-left: auto;
            margin-right: auto;
            width: 80%;
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <div class="navbar-brand">
            <a href="<%=request.getContextPath()%>" class="nav-link">Sample Shopping</a>
        </div>
    </nav>
</header>
<div class="container">
    <h3 class="text-center mt-3">List of Products</h3>
    <hr>
    <table class="table table-striped table_center">
        <thead class="alert alert-info">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Photo</th>
            <th>Price</th>
            <th>Buy</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td><img src="${pageContext.request.contextPath}/images/${product.image}" width="120"></td>
                <td>${product.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/cart?action=buy&id=${product.id}" class="btn btn-sm btn-success">Buy</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
