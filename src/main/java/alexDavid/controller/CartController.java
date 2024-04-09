package alexDavid.controller;

import alexDavid.dtos.CartDto.CartRequestDto;
import alexDavid.dtos.CartDto.CartResponseDto;
import alexDavid.mappers.CartMapper;
import alexDavid.models.Cart;
import alexDavid.service.CartService.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/divehub/carts")
@RequiredArgsConstructor
@CrossOrigin
public class CartController {
    private final CartService cartService;
    private final CartMapper cartMapper;

    @GetMapping("/{email}")
    public ResponseEntity<List<CartResponseDto>> getListByUser(
            @PathVariable String email
    ){
        return ResponseEntity.ok(cartMapper.toResponse(cartService.getListByUser(email)));
    }

    @GetMapping("/count/{email}")
    public ResponseEntity<Long> countByClient(
            @PathVariable("email") String email
    ){
        return ResponseEntity.ok(cartService.getCountByClient(email));
    }


    @GetMapping("/totalPrice/{email}")
    public ResponseEntity<Double> getTotalPrice(
            @PathVariable String email
    ) {
        double totalPrice = cartService.getTotalPriceByEmail(email);
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }


    @GetMapping("/updateQuantity/{user_email}/{product_id}/{quantity}")
    public ResponseEntity<CartResponseDto> updateProductQuantity(
            @PathVariable("user_email") String user_email,
            @PathVariable("product_id") Long productId,
            @PathVariable("quantity") int quantity
    ){
        return new ResponseEntity<>(cartMapper.toResponse(cartService.updateProductQuantity(user_email, productId, quantity)), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CartResponseDto> addProduct(
            @RequestBody CartRequestDto cartRequestDto
    ){
        Cart cart = cartMapper.toModel(cartRequestDto);
        if (cartService.isProductInCart(cart))
            return new ResponseEntity<>(cartMapper.toResponse(cartService.updateProductQuantity(cart.getUser().getEmail(), cart.getProduct().getId(), cart.getAmount())), HttpStatus.OK);
        else return new ResponseEntity<>(cartMapper.toResponse(cartService.addProduct(cart)), HttpStatus.OK);

    }

    @DeleteMapping("/clean/{product_id}")
    public ResponseEntity<?> removeProduct(
            @PathVariable("product_id") Long id
    ){
        cartService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cleanAll/{email}")
    public ResponseEntity<?> removeAllProducts(
            @PathVariable("email") String email
    ){
        cartService.cleanCart(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
