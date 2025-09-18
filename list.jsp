<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, models.Product" %>
<html>
<body>
<h2>Danh sách sản phẩm</h2>
<table border="1">
<tr><th>ID</th><th>Tên</th><th>Giá</th><th>Ảnh</th></tr>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
    for (Product p : products) {
%>
<tr>
<td><%=p.getId()%></td>
<td><%=p.getName()%></td>
<td><%=p.getPrice()%></td>
<td><img src="<%=p.getImage()%>" width="50"></td>
</tr>
<% } %>
</table>
<a href="add.jsp">Thêm sản phẩm mới</a>
</body>
</html>
