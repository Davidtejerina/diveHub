package mappers;

import dtos.ProductRequesDto;
import dtos.ProductResponseDto;
import models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    /*
     * pasamos de producto a ResponsDto*/
    public ProductResponseDto toResponse(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStartingPrice(),
                product.getFinalPrice(),
                product.getImage()
        );
    }


    public List<ProductResponseDto> toResponse(List<Product> products) {
        return products.stream().
                map(this::toResponse).
                toList();
    }

    public Product toModel(ProductRequesDto productRequesDto) {

        return new Product(
                0L,
                productRequesDto.getName(),
                productRequesDto.getDescription(),
                productRequesDto.getStartingPrice(),
                productRequesDto.getFinalPrice(),
                productRequesDto.getImage()

        );
    }
}
