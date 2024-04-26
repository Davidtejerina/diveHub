package alexDavid.service.CartService;

import alexDavid.models.Cart;
import alexDavid.models.Product;
import alexDavid.models.User.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartService {

    java.util.List<Cart> getListByUser(String email);
    void cleanCart(String email);
    void addProduct(Cart cart);
    Long getCountByClient(String email);
    double getTotalPriceByEmail(String email);
    void updateProductQuantity(String user_email, Long productId, Integer quantity);
    boolean isProductInCart(Cart cart);
    void removeProduct(String email, Long productId);

}
