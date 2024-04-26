package alexDavid.controller;

import alexDavid.dtos.CartDTO.CartResponseDto;
import alexDavid.dtos.ProductDto.ProductResponseDto;
import alexDavid.mappers.CartMapper;
import alexDavid.models.Cart;
import alexDavid.service.CartService.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diveHub/cart")
@RequiredArgsConstructor
@CrossOrigin
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    @GetMapping("/all")
    public ResponseEntity<List<CartResponseDto>> getAllCart(
    ) {
        return ResponseEntity.ok(cartMapper.toResponse(cartService.findAll()));
    }


    @GetMapping("/{userId}")
    public ResponseEntity<List<Long>> getProductCartByUserId(
            @PathVariable Long userId
    ) {

       return ResponseEntity.ok(this.cartService.findAllByUser(userId));
    }
}