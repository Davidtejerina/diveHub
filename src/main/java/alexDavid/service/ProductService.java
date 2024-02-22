package alexDavid.service;


import alexDavid.models.Category;
import alexDavid.models.Product;

import java.util.List;

public interface ProductService {

    Product findById(Long id);

    List<Product> findProductsByName(String description);

    List<Product> findProductByCategory(Category category);

    List<Product> findAll();

    Product save(Product product);
}
