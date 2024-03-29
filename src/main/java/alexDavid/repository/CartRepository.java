package alexDavid.repository;

import alexDavid.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser_Email(String userEmail);
    Cart findByUser_EmailAndProduct_Id(String userEmail, Long productId);
    void deleteByUser_Email(String email);
    void deleteByProduct_Id(Long productId);
    Long countByUser_Email(String email);
}
