package service;


import models.Category;
import models.Product;
import java.util.List;

public interface ProductService {

    Product findById(Long id);

    List<Product> findProductsByName(String description);

    List<Product> findProductByCategory(Category category);

    List<Product> findAll();
}
