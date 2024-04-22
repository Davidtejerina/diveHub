//package alexDavid.service;
//
//import alexDavid.models.*;
//import alexDavid.models.User.User;
//import alexDavid.service.ActivityService.ActivityService;
//import alexDavid.service.ItemService.ItemService;
//import alexDavid.service.ProductService.ProductService;
//import alexDavid.service.WishListService.WishListService;
//import lombok.RequiredArgsConstructor;
//import net.datafaker.Faker;
//import org.springframework.stereotype.Service;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.util.List;
//import java.util.Locale;
//import java.util.concurrent.TimeUnit;
//
//
//@Service
//@RequiredArgsConstructor
//public class InitialDataCreationService {
//    private final ProductService productService;
//    private final ItemService itemService;
//    private final ActivityService activityService;
//    private final WishListService wishListService;
//    private final Faker faker = new Faker(new Locale("en-US"));
//    private final UserDetailsServiceImpl userDetailsService;
//
//
//    public void createFakeProducts(int number) {
//        if (number <= 0) return;
//
//        for (int i = 0; i < number; i++) {
//
//            int categoryIndex;
//            if (Math.random() < 0.5) categoryIndex = 0;     // Asi hay 50% de ser product y 50% de ser course o dive
//            else categoryIndex = faker.number().numberBetween(1, Category.values().length);
//
//            Category category = Category.values()[categoryIndex];
//
//            if (category == Category.COURSE || category == Category.DIVE) createFakeActivity(category);
//            else createFakeItem(category);
//        }
//    }
//
//
//    private void createFakeActivity(Category category) {
//        int levelIndex = faker.number().numberBetween(0, Level.values().length);
//        Level level = Level.values()[levelIndex];
//
//        LocalDateTime startingDate = faker.date().future(30, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//        LocalDateTime endDate = startingDate.plusDays(faker.number().numberBetween(1, 10));
//
//        int available_spaces = faker.number().randomDigit();
//        boolean available = available_spaces != 0;
//
//        Activity activity = new Activity(
//                null,
//                faker.commerce().productName(),
//                faker.lorem().sentence(20),
//                faker.number().randomDouble(2, 50, 100),
//                faker.number().randomDouble(2, 50, 100),
//                faker.avatar().image(),
//                category,
//                level,
//                startingDate,
//                endDate,
//                available_spaces,
//                available,
//                faker.commerce().department()
//        );
//        activityService.save(activity);
//    }
//
//
//    private void createFakeItem(Category category) {
//        Item item = new Item(
//                null,
//                faker.commerce().productName(),
//                faker.lorem().sentence(20),
//                faker.number().randomDouble(2, 50, 100),
//                faker.number().randomDouble(2, 50, 100),
//                faker.avatar().image(),
//                faker.number().randomDouble(2, 0, 5),
//                category,
//                faker.commerce().department(),
//                faker.number().randomDigit()
//        );
//        itemService.save(item);
//    }
//
//
//    public void createFakeUser(){
//        User user = new User("user", "$2a$12$K4tojeaYWMK55KzWzDWtLOuuUjRTkycWhSGHYWA2LXMZqmZUtuXPO"); // Esto es "password" codificado con bcrypt)
//        userDetailsService.save(user);
//    }
//
//    public void createFakeCartsForUser(int number) {
//        if (number <= 0) return;
//
//        List<Product> products = productService.findAll();
//        for (int i = 0; i < number; i++) {
//            Cart cart = new Cart(
//                    null,
//                    userDetailsService.loadUserByUserEmail("user"),
//                    products.get(i),
//                    faker.number().numberBetween(1, 5)
//            );
//            cartService.save(cart);
//        }
//    }
//
//    public void createFakeWishListsForUser(int number) {
//        if (number <= 0) return;
//
//        List<Product> products = productService.findAll();
//        for (int i = 0; i < number; i++) {
//            WishList WishList = new WishList(
//                    null,
//                    userDetailsService.loadUserByUserEmail("user"),
//                    products.get(i)
//            );
//            wishListService.save(WishList);
//        }
//    }
//}
