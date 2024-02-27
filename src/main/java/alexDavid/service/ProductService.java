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
    List<Product> findProductsByTagIgnoreCase(String tag);
    List<Product> findByNameContainsIgnoreCase(String name);
    List<Product> findAllByOrderByFinal_priceDesc();
    List<Product> findAllByOrderByFinal_priceAsc();
    void deleteProductById(Long id);
    Product update (Long id, Product product);

}
