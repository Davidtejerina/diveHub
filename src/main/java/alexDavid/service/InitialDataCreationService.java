package alexDavid.service;

import alexDavid.models.Category;
import lombok.RequiredArgsConstructor;
import alexDavid.models.Product;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class InitialDataCreationService {
    private final ProductService productService;
    private final Faker faker = new Faker(new Locale("en-US"));

    public void createFakeProducts(int number) {
        if(number <= 0) return;

        for (int i = 0; i < number; i++) {
            int categoryIndex = faker.number().numberBetween(0, Category.values().length);
            Category category = Category.values()[categoryIndex];

            Product product = new Product(
                    null,
                    faker.commerce().productName(),
                    faker.lorem().sentence(20),
                    faker.number().randomDouble(2, 50, 100),
                    faker.number().randomDouble(2, 50, 100),
                    faker.avatar().image(),
                    category,
                    faker.commerce().department()
            );
            productService.save(product);
        }
    }
}
