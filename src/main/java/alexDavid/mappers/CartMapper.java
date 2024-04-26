package alexDavid.mappers;

import alexDavid.dtos.CartDTO.CartRequestDto;
import alexDavid.dtos.CartDTO.CartResponseDto;
import alexDavid.models.Cart;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartMapper {

    public CartResponseDto toResponse(Cart cart) {
        return new CartResponseDto(
                cart.getId(),
                cart.getUserId(),
                cart.getProductId(),
                cart.getQuantity()
        );
    }
    public List<CartResponseDto> toResponse(List<Cart> carts) {
        return carts.stream().
                map(this::toResponse).
                toList();
    }


    public Cart toModel(CartRequestDto cartDto) {

        return new Cart(
                null,
                cartDto.getUserId(),
                cartDto.getProductId(),
                cartDto.getQuantity()
        );
    }
}