package alexDavid.service.CartService;

import alexDavid.models.Cart;


public interface CartService {
    java.util.List<Cart> getListByUser(String email);
    void cleanCart(String email);
    void removeProduct(Long productId);
    Cart addProduct(Cart cart);
    Cart save(Cart cart);
    Long getCountByClient(String email);
    double getTotalPriceByEmail(String email);
    Cart updateProductQuantity(String user_email, Long productId, int quantity);
    boolean isProductInCart(Cart cart);
}














