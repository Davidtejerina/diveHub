package alexDavid.mappers;

import alexDavid.dtos.OrderDto.OrderRequestDto;
import alexDavid.dtos.OrderDto.OrderResponseDto;
import alexDavid.models.Order;
import org.springframework.stereotype.Component;


@Component
public class OrderMapper {
    public OrderResponseDto toResponse(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getUser(),
                order.getTotal(),
                order.getAddress(),
                order.getDate()
        );
    }

    public Order toModel(OrderRequestDto orderDTO) {
        return new Order(
                null,
                orderDTO.getUser(),
                orderDTO.getTotal(),
                orderDTO.getAddress(),
                orderDTO.getDate()
        );
    }
}
