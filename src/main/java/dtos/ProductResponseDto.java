package dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    private final Double startingPrice;
    private final Double finalPrice;
    private final String image;
}
