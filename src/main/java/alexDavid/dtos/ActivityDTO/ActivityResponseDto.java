package alexDavid.dtos.ActivityDTO;

import alexDavid.models.Category;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor(force = true) // Para que no me de error en el constructor de jackson
@RequiredArgsConstructor // Para que me cree un constructor con los atributos finales
@Builder

public class ActivityResponseDto {
    private final Long id;
    private final String name;
    private final String description;
    private final Double starting_price;
    private final Double final_price;
    private final String image;
    private final Category category;
    private final String tag;
    private final Integer level_required;
    private final LocalDateTime time_starts;
    private final LocalDateTime time_ends;
    private final Integer available_spaces;
    private final Boolean available;
}
