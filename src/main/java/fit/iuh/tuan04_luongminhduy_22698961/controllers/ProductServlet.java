package controllers;

import daos.ProductDAO;
import daos.ProductDAOImpl;
import entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        try {
            // Lấy DataSource từ context (nếu bạn đã cấu hình JNDI)
            DataSource ds = (DataSource) getServletContext().getAttribute("DBCPool");
            productDAO = new ProductDAOImpl(ds);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Product> products = productDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/product/index.jsp").forward(req, resp);
    }
}
