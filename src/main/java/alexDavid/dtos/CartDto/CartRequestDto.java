package alexDavid.dtos.CartDto;

import alexDavid.models.Product;
import alexDavid.models.User.User;
import lombok.Data;

@Data
public class CartRequestDto {
    private final User user;
    private final Product product;
    private final int amount;
}
