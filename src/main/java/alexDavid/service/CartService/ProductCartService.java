package alexDavid.service.CartService;

import alexDavid.models.ProductCart;
import alexDavid.models.Product;

public interface ProductCartService {

    /*findAllByUser
    findByUserAndProductId
    addToCartByUser
    UpdateCartByUserAndProductId
    DeleteByUserAndProductId
    deleteAllByUser*/

    ProductCart findAllByUser (Long userId);
    void addProduct (Long userId, Product productId);
}
