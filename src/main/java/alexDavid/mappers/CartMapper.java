package alexDavid.mappers;

import alexDavid.dtos.CartDto.CartRequestDto;
import alexDavid.models.Cart;
import org.springframework.stereotype.Component;


@Component
public class CartMapper {
    public Cart toModel(CartRequestDto cartDTO) {
        return new Cart(
                null,
                cartDTO.getUser(),
                cartDTO.getProduct(),
                cartDTO.getAmount()
        );
    }
}
