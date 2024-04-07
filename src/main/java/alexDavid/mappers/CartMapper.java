package alexDavid.mappers;

import alexDavid.dtos.ActivityDTO.ActivityResponseDto;
import alexDavid.dtos.CartDto.CartRequestDto;
import alexDavid.dtos.CartDto.CartResponseDto;
import alexDavid.models.Activity;
import alexDavid.models.Cart;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CartMapper {

    public CartResponseDto toResponse(Cart cart) {
        return new CartResponseDto(
                cart.getId(),
                cart.getUser(),
                cart.getProduct(),
                cart.getAmount()
        );
    }
    public List<CartResponseDto> toResponse(List<Cart> carts) {
        return carts.stream().
                map(this::toResponse).
                toList();
    }
    public Cart toModel(CartRequestDto cartDTO) {
        return new Cart(
                null,
                cartDTO.getUser(),
                cartDTO.getProduct(),
                cartDTO.getAmount()
        );
    }
}
