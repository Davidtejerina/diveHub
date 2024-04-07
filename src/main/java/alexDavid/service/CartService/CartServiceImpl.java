package alexDavid.service.CartService;

import alexDavid.models.Cart;
import alexDavid.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CartServiceImpl implements CartService{
    private final CartRepository cartRepository;

    @Override
    public List<Cart> getListByUser(String email){
        return cartRepository.findByUser_Email(email);
    }

    @Override
    public void cleanCart(String email){
        cartRepository.deleteByUser_Email(email);
    }

    @Override
    public void removeProduct(Long productId){
        cartRepository.deleteByProduct_Id(productId);
    }

    @Override
    public Cart addProduct(Cart cart){
        return cartRepository.save(cart);
    }

    @Override
    public Long getCountByClient(String email){
        return cartRepository.countByUser_Email(email);
    }

    @Override
    public double getTotalPriceByEmail(String email) {
        List<Cart> cartItems = getListByUser(email);
        return cartItems.stream()
                .mapToDouble(cart -> cart.getProduct().getFinal_price() * cart.getAmount())
                .sum();
    }

    @Override
    public Cart updateProductQuantity(String user_email, Long productId, int quantity) {
        Cart cart = cartRepository.findByUser_EmailAndProduct_Id(user_email, productId);
        cart.setAmount(quantity);
        return cartRepository.save(cart);
    }

    @Override
    public boolean isProductInCart(Cart cart) {
        return cartRepository.findByUser_EmailAndProduct_Id(cart.getUser().getEmail(), cart.getProduct().getId()) != null;
    }
}














