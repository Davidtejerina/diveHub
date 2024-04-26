package alexDavid.controller;

import alexDavid.dtos.CartDTO.CartRequestDto;
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

    @GetMapping("/all/{email}")
    public ResponseEntity<List<Cart>> getListByUser(
            @PathVariable String email
    ){
        return ResponseEntity.ok(cartService.getListByUser(email));
    }

    @GetMapping("/count/{email}")
    public ResponseEntity<Long> countByClient(
            @PathVariable String email
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


    @GetMapping("/updateQuantity/{product_id}/{quantity}/{user_email}")
    public ResponseEntity<?> updateProductQuantity(
            @PathVariable String user_email,
            @PathVariable Long product_id,
            @PathVariable Integer quantity
    ){
        cartService.updateProductQuantity(user_email, product_id, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addProduct(
            @RequestBody CartRequestDto cartRequestDto
    ){
        Cart cart = cartMapper.toModel(cartRequestDto);
        if (cartService.isProductInCart(cart)) cartService.updateProductQuantity(cart.getUser().getEmail(), cart.getProductId(), cart.getQuantity());
        else cartService.addProduct(cart);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/clean/{email}/{productId}")
    public ResponseEntity<?> removeProduct(
            @PathVariable String email,
            @PathVariable Long productId
    ){
        this.cartService.removeProduct(email, productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/cleanAll/{email}")
    public ResponseEntity<?> removeAllProducts(
            @PathVariable String email
    ){
        this.cartService.cleanCart(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}