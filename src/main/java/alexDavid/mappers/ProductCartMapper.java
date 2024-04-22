package alexDavid.mappers;

import alexDavid.dtos.CartDTO.CartRequestDto;
import alexDavid.dtos.CartDTO.CartResponseDto;
import alexDavid.models.ProductCart;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductCartMapper {

    public CartResponseDto toResponse(ProductCart cart){
        return new CartResponseDto(
                cart.getId(),
                cart.getUser(),
                cart.getItem(),
                cart.getActivity(),
                cart.getQuantity()
        );
    }

    public List<CartResponseDto> toResponse(List<ProductCart> carts) {
        return carts.stream().
                map(this::toResponse).
                toList();
    }

public ProductCart toModel(CartRequestDto cartDto){
    return new ProductCart(
            null,
            cartDto.getUser(),
            cartDto.getItem(),
            cartDto.getActivity(),
            cartDto.getQuantity()
    );
}
}
