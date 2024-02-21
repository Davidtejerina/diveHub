package dtos.ProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import models.Category;

@Data
@AllArgsConstructor
public class ProductRequesDto {
    private final String name;
    private final String description;
    private final Double starting_price;
    private final Double final_price;
    private final String image;
    private final Category category;
}
