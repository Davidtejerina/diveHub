package alexDavid.service.CartService;

import alexDavid.models.Cart;


public interface CartService {
    java.util.List<Cart> getListByUser(String email);
    void cleanCart(String email);
    void save(Cart cart);
    void removeProduct(Long productId);
    void addProduct(Cart cart);
    Long getCountByClient(String email);
    double getTotalPriceByEmail(String email);
    void updateProductQuantity(String user_email, Long productId, int quantity);
    boolean isProductInCart(Cart cart);
}














