package alexDavid.repository;

import alexDavid.models.ProductCart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCartRepository extends JpaRepository<ProductCart, Long> {
    List<ProductCart> findByUser_Email(String email);

    ProductCart findByUser_Id(Long id);


}
