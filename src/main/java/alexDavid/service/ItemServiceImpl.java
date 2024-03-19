package alexDavid.service;

import alexDavid.models.Category;
import alexDavid.models.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import alexDavid.repository.ItemRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository productRepository;

    @Override
    public Item findById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public List<Item> findProductsByName(String name) {
        return productRepository.findProductsByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Item> findProductByCategory(Category category) {
        return productRepository.findProductsByCategory(category);
    }

    @Override
    public List<Item> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Item save(Item product){
        return productRepository.save(product);
    }

    @Override
    public List<Item> findProductsByTagIgnoreCase(String tag) {
        return productRepository.findProductsByTagIgnoreCase(tag);
    }

    @Override
    public List<Item> findByNameContainsIgnoreCase(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public void deleteProductById(Long id) {productRepository.deleteById(id);
    }

    @Override
    public Item update(Long id, Item product) {
        Item productUpdated = this.findById(id);

        productUpdated.setName(product.getName());
        productUpdated.setDescription(product.getDescription());
        productUpdated.setStarting_price(productUpdated.getStarting_price());
        productUpdated.setFinal_price(product.getFinal_price());
        productUpdated.setImage(product.getImage());
        productUpdated.setCategory(product.getCategory());
        productUpdated.setTag(product.getTag());

        return productRepository.save(productUpdated);
    }


    @Override
    public List<Item> findAllByOrderByFinal_priceDesc() {
        return productRepository.findAllOrderByFinal_price();
    }

    @Override
    public List<Item> findAllByOrderByFinal_priceAsc() {
        return productRepository.findAllOrderByFinal_priceAsc();
    }
}
