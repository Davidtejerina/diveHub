package alexDavid.service.CartService;

import alexDavid.models.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    /*findAllByUser
    findByUserAndProductId
    addToCartByUser
    UpdateCartByUserAndProductId
    DeleteByUserAndProductId
    deleteAllByUser*/

    List<Cart> findAll ();

    List<Long> findAllByUser (Long userId);
  /*  void addProductCart(Long userId, Long productId, Integer quantity);*/
    void removeByUserID(Long userId);


}
