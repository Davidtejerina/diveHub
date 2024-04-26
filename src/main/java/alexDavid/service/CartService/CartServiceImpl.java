package alexDavid.service.CartService;

import alexDavid.models.Cart;
import alexDavid.models.WishList;
import alexDavid.repository.CartRepository;
import alexDavid.repository.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public List<Long> findAllByUser (Long userId){
        return cartRepository.findByUserId(userId);
    }

   /* public void addProductCart(Long userId, Long productId) {
        // Buscar si existe un registro en el carrito para el productId y userId especificados
        Cart cartItem = cartRepository.findByUserIdAndProductId(userId, productId);

        if (cartItem != null) {
            // Si el registro ya existe, incrementar la cantidad
            cartItem.setQuantity(cartItem.getQuantity() );
        } else {
            // Si el registro no existe, crear uno nuevo
            cartItem = new Cart();
            cartItem.setUserId(userId);
            cartItem.setProductId(productId);
            cartItem.setQuantity(1);
        }

        cartRepository.save(cartItem);
    }*/

    @Override
    public void removeByUserID(Long userId) {
        this.cartRepository.deleteCartByUserId(userId);
    }


}

