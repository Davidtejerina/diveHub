package alexDavid.service;

import alexDavid.models.Activity;
import alexDavid.models.Category;
import alexDavid.models.Level;
import alexDavid.models.User.User;
import lombok.RequiredArgsConstructor;
import alexDavid.models.Product;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class InitialDataCreationService {
    private final ProductService productService;
    private final ActivityService activityService;
    private final Faker faker = new Faker(new Locale("en-US"));
    private final UserDetailsServiceImpl userDetailsService;
    public void createFakeProducts(int number) {
        if (number <= 0) return;

        for (int i = 0; i<number; i++) {
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

            if (product.getCategory() == Category.COURSE || product.getCategory() == Category.DIVE) createFakeActivity(product);
            else productService.save(product);
        }
    }
    public void createFakeActivity(Product product) {
        int levelIndex = faker.number().numberBetween(0, Level.values().length);
        Level level = Level.values()[levelIndex];

        LocalDateTime startingDate = faker.date().future(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime endDate = startingDate.plusDays(faker.number().numberBetween(1, 10));

        Activity activity = new Activity(
                null,
                product.getName(),
                product.getDescription(),
                product.getStarting_price(),
                product.getFinal_price(),
                product.getImage(),
                product.getCategory(),
                level,
                startingDate,
                endDate,
                faker.number().randomDigit(),
                faker.bool().bool(),
                product.getTag()
        );
        activityService.save(activity);
    }

    public void createFakeUser(){
        User user = new User("user", "$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO"); // Esto es "password" codificado con bcrypt)
        userDetailsService.save(user);
    }
}
