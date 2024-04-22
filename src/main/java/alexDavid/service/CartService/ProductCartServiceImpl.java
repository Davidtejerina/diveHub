package alexDavid.service.CartService;

import alexDavid.models.Product;
import alexDavid.models.ProductCart;
import alexDavid.repository.ProductCartRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductCartServiceImpl implements ProductCartService {

    private final ProductCartRepository productCartRepository;


    @Override
    public ProductCart findAllByUser (Long userId){
        return productCartRepository.findByUser_Id(userId);
    }

    @Override
    public void addProduct(Long userId, Product productId) {

    }

}
