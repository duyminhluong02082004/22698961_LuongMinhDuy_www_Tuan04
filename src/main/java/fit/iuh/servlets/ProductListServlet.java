package servlets;

import daos.impl.ProductDAOImpl;
import models.Product;
import utils.DBUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDAOImpl dao = new ProductDAOImpl(DBUtil.getDataSource());
        List<Product> list = dao.findAll();
        req.setAttribute("products", list);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
