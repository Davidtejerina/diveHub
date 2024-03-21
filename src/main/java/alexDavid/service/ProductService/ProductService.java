package alexDavid.service.ProductService;

import alexDavid.models.Category;
import alexDavid.models.Product;
import java.util.List;


public interface ProductService {
    Product findById(Long id);
    List<Product> findByCategory(Category category);
    List<Product> findAll();
    List<Product> findProductsByTagIgnoreCase(String tag);
    List<Product> findByNameContainsIgnoreCase(String name);
    List<Product> findAllByOrderByFinal_priceDesc();
    List<Product> findAllByOrderByFinal_priceAsc();
    void deleteById(Long id);
}
