package alexDavid.dtos.WishListDto;

import alexDavid.models.Activity;
import alexDavid.models.Item;
import alexDavid.models.Product;
import alexDavid.models.User.User;
import lombok.Data;

@Data
public class WishListRequestDto {
    private final User user;
    private final Item item;
    private final Activity activity;
}
