package alexDavid.repository;

import alexDavid.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart  c WHERE c.userId = :userId")
    List<Long> findByUserId(Long userId);

    Cart findByUserIdAndProductId(Long userId, Long productId);

    void deleteCartByUserId (Long userId);

}
