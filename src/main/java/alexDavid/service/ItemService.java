package alexDavid.service;

import alexDavid.models.Category;
import alexDavid.models.Item;
import java.util.List;


public interface ItemService {
    Item findById(Long id);
    List<Item> findProductsByName(String description);
    List<Item> findProductByCategory(Category category);
    List<Item> findAll();
    Item save(Item product);
    List<Item> findProductsByTagIgnoreCase(String tag);
    List<Item> findByNameContainsIgnoreCase(String name);
    List<Item> findAllByOrderByFinal_priceDesc();
    List<Item> findAllByOrderByFinal_priceAsc();
    void deleteProductById(Long id);
    Item update (Long id, Item product);

}
