package alexDavid.repository;

import alexDavid.models.Category;
import alexDavid.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByNameContainsIgnoreCase(String name);
    List<Product> findProductByCategory(Category category);
    List<Product> findProductsByTagIgnoreCase(String tag);
    List<Product> findByNameContainsIgnoreCase(String name);
//    List<Product> findAllByOrderByFinal_price();

}
