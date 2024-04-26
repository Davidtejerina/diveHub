package alexDavid.dtos.CartDTO;

import alexDavid.models.Product;
import alexDavid.models.User.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartRequestDto {
    private final User user;
    private final Long ProductId;
    private final Integer quantity;
}
