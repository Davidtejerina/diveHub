package alexDavid.service.WishListService;

import alexDavid.models.WishList;


public interface WishListService {
    java.util.List<WishList> getListByUser(String email);
    void cleanWishList(String email);
    void save(WishList wishList);
    void removeProduct(Long itemId, Long activityId, String email);
    void addProduct(WishList wishList);
    Boolean isProductLiked(String email, Long itemId, Long activityId);
    Boolean isItem(Long productId);
}














