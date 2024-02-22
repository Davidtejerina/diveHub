package alexDavid.dtos.ProductDTO;

import lombok.Data;
import alexDavid.models.Category;

@Data
public class ProductRequesDto {
    private final String name;
    private final String description;
    private final Double starting_price;
    private final Double final_price;
    private final String image;
    private final Category category;
    private final String tag;
}
