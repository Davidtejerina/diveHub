package alexDavid.dtos.DetailDto;

import alexDavid.models.Order;
import alexDavid.models.User.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetailRequestDto {
    private final Order order;
    private final Long productId;
    private final Integer quantity;
}
