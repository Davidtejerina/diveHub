package alexDavid.dtos.ProductDTO;

import lombok.Builder;
import lombok.Data;
import alexDavid.models.Category;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force = true) // Para que no me de error en el constructor de jackson
@RequiredArgsConstructor // Para que me cree un constructor con los atributos finales
@Builder
public class ProductRequestDto {
    private final String name;
    private final String description;
    private final Double starting_price;
    private final Double final_price;
    private final String image;
    private final Double weight;
    private final Category category;
    private final String tag;
}
