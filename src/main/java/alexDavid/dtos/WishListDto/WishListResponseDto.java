package alexDavid.dtos.WishListDto;

import alexDavid.models.Product;
import alexDavid.models.User.User;
import lombok.Data;

@Data
public class WishListResponseDto {
    private final Long id;
    private final User user;
    private final Product product;
}
