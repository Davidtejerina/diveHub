package alexDavid.controller;

import alexDavid.dtos.CartDto.CartRequestDto;
import alexDavid.mappers.CartMapper;
import alexDavid.models.Cart;
import alexDavid.service.CartService.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{email}")
    public ResponseEntity<List<Cart>> getListByUser(
            @PathVariable String email
    ){
        return ResponseEntity.ok(this.cartService.getListByUser(email));
    }

    @GetMapping("/count/{email}")
    public ResponseEntity<Long> countByClient(
            @PathVariable("email") String email
    ){
        return ResponseEntity.ok(this.cartService.getCountByClient(email));
    }


    @GetMapping("/totalPrice/{email}")
    public ResponseEntity<Double> getTotalPrice(
            @PathVariable String email
    ) {
        double totalPrice = cartService.getTotalPriceByEmail(email);
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }


    @GetMapping("/updateQuantity/{user_email}/{product_id}/{quantity}")
    public ResponseEntity<?> updateProductQuantity(
            @PathVariable("user_email") String user_email,
            @PathVariable("product_id") Long productId,
            @PathVariable("quantity") int quantity
    ){
        this.cartService.updateProductQuantity(user_email, productId, quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<?> addProduct(
            @RequestBody CartRequestDto cartRequestDto
    ){
        Cart cart = cartMapper.toModel(cartRequestDto);
        if (cartService.isProductInCart(cart)) cartService.updateProductQuantity(cart.getUser().getEmail(), cart.getProduct().getId(), cart.getAmount());
        else cartService.addProduct(cart);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/clean/{product_id}")
    public ResponseEntity<?> removeProduct(
            @PathVariable("product_id") Long id
    ){
        this.cartService.removeProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/cleanAll/{email}")
    public ResponseEntity<?> removeAllProducts(
            @PathVariable("email") String email
    ){
        this.cartService.cleanCart(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
