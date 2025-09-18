package daos;

import java.util.List;
import models.Product;

public interface ProductDAO {
    List<Product> findAll();
    Product getById(int id);
    void addProduct(Product p);
}
