package repository;

import models.Category;
import models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByNameContainsIgnoreCase(String name);

    List<Product> findProductByCategory(Category category);

    @Override
    List<Product> findAll();
}
