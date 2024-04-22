package alexDavid.service.WishListService;

import alexDavid.models.WishList;
import alexDavid.repository.ItemRepository;
import alexDavid.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService {
    private final WishListRepository wishListRepository;
    private final ItemRepository itemRepository;

    @Override
    public List<WishList> getListByUser(String email){
        return this.wishListRepository.findByUser_Email(email);
    }

    @Override
    public void cleanWishList(String email){
        this.wishListRepository.deleteByUser_Email(email);
    }

    @Override
    public void save(WishList wishList) {
        this.wishListRepository.save(wishList);
    }

    @Override
    public void removeProduct(Long itemId, Long activityId, String email){
        this.wishListRepository.deleteByItem_IdOrActivity_IdAndUser_Email(itemId, activityId, email);
    }

    @Override
    public void addProduct(WishList wishList){
        if(wishListRepository.isItemOrActivityLiked(wishList.getItem().getId(), wishList.getActivity().getId(), wishList.getUser().getEmail())) return;
        this.wishListRepository.save(wishList);
    }

    @Override
    public Boolean isProductLiked(String email, Long itemId, Long activityId) {
        return wishListRepository.isItemOrActivityLiked(itemId, activityId, email);
    }

    @Override
    public Boolean isItem(Long productId) {
        return itemRepository.findById(productId).isPresent();
    }
}














