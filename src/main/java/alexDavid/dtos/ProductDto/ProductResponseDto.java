package alexDavid.dtos.ProductDto;

import alexDavid.models.Category;
import alexDavid.models.Level;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    private final Double starting_price;
    private final Double final_price;
    private final String image;
    private final Category category;
    private final String tag;
}
