package alexDavid.service;

import alexDavid.models.Activity;
import alexDavid.models.Category;
import lombok.RequiredArgsConstructor;
import alexDavid.models.Product;
import net.datafaker.Faker;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class InitialDataCreationService {
    private final ProductService productService;
    private final ActivityService activityService;
    private final Faker faker = new Faker(new Locale("en-US"));

    public Product createFakeProducts(int number) {
        if (number <= 0) return null;

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
            return product;
        }
        return null;
    }


    public  Activity createFakeActivity(int numberOfActivities) {
        if (numberOfActivities <= 0) return null;

        for (int i = 0; i < numberOfActivities; i++) {
            Product product = createFakeProducts(1);
            if (product == null) {
                return null;
            }

            Activity activity = new Activity(
                    product.getId(),
                    product.getName(),
                    product.getDescription(),
                    product.getStarting_price(),
                    product.getFinal_price(),
                    product.getImage(),
                    product.getCategory(),
                    faker.number().randomDigit(),
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    faker.number().randomDigit(),
                    faker.bool().bool(),
                    product.getTag()
            );
            activityService.save(activity);


        }
        return null;
    }
}
