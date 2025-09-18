package servlets;

import daos.impl.ProductDAOImpl;
import models.Product;
import utils.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");

        ProductDAOImpl dao = new ProductDAOImpl(DBUtil.getDataSource());
        dao.addProduct(new Product(name, price, image));

        resp.sendRedirect("products");
    }
}
