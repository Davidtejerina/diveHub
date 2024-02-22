package alexDavid.mappers;

import alexDavid.dtos.ProductDTO.ProductRequesDto;
import alexDavid.dtos.ProductDTO.ProductResponseDto;
import alexDavid.models.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductMapper {

    public ProductResponseDto toResponse(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getStarting_price(),
                product.getFinal_price(),
                product.getImage(),
                product.getCategory()
        );
    }


    public List<ProductResponseDto> toResponse(List<Product> products) {
        return products.stream().
                map(this::toResponse).
                toList();
    }

    public Product toModel(ProductRequesDto productRequesDto) {
        return new Product(
                null,
                productRequesDto.getName(),
                productRequesDto.getDescription(),
                productRequesDto.getStarting_price(),
                productRequesDto.getFinal_price(),
                productRequesDto.getImage(),
                productRequesDto.getCategory()
        );
    }
}
