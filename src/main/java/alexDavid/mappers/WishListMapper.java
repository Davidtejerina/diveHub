package alexDavid.mappers;

import alexDavid.dtos.WishListDto.WishListRequestDto;
import alexDavid.models.WishList;
import org.springframework.stereotype.Component;


@Component
public class WishListMapper {
    public WishList toModel(WishListRequestDto wishListDTO) {
        return new WishList(
                null,
                wishListDTO.getUser(),
                wishListDTO.getProduct()
        );
    }
}
