package alexDavid.repository;

import alexDavid.models.Category;
import alexDavid.models.Item;
import alexDavid.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByCategory(Category category);
    List<Product> findProductsByTagIgnoreCase(String tag);
    List<Product> findByNameContainsIgnoreCase(String name);
    @Query("SELECT p FROM Product p ORDER BY p.final_price DESC")
    List<Product> findAllOrderByFinal_price();
    @Query("SELECT p FROM Product p ORDER BY p.final_price ASC")
    List<Product> findAllOrderByFinal_priceAsc();
}
