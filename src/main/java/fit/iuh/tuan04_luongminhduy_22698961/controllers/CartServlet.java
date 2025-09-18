package controllers;

import entities.ItemCart;
import entities.Product;
import daos.ProductDAO;
import daos.ProductDAOImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.*;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private ProductDAO productDAO;

    @Override
    public void init() throws ServletException {
        try {
            DataSource ds = (DataSource) getServletContext().getAttribute("DBCPool");
            productDAO = new ProductDAOImpl(ds);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        @SuppressWarnings("unchecked")
        List<ItemCart> cart = (List<ItemCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        String action = req.getParameter("action");
        String idStr = req.getParameter("id");

        if ("buy".equals(action) && idStr != null) {
            int id = Integer.parseInt(idStr);
            Product p = productDAO.getById(id);
            if (p != null) {
                boolean found = false;
                for (ItemCart item : cart) {
                    if (item.getProduct().getId() == id) {
                        item.setQuantity(item.getQuantity() + 1);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    cart.add(new ItemCart(p, 1));
                }
            }
        } else if ("remove".equals(action) && idStr != null) {
            int id = Integer.parseInt(idStr);
            cart.removeIf(item -> item.getProduct().getId() == id);
        }

        req.setAttribute("cart", cart);
        req.getRequestDispatcher("/views/cart/index.jsp").forward(req, resp);
    }
}
