package alexDavid.controller;

import alexDavid.dtos.WishListDto.WishListRequestDto;
import alexDavid.mappers.WishListMapper;
import alexDavid.models.WishList;
import alexDavid.service.WishListService.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diveHub/wishes")
@RequiredArgsConstructor
@CrossOrigin
public class WishListController {
    private final WishListService wishListService;
    private final WishListMapper wishListMapper;


    @GetMapping("/{email}")
    public ResponseEntity<List<WishList>> getListByUser(
            @PathVariable String email
    ){
        return ResponseEntity.ok(this.wishListService.getListByUser(email));
    }


    @GetMapping("/{email}/{product}")
    public ResponseEntity<Boolean> isProductOnWishList (
            @PathVariable String email,
            @PathVariable Long product
    ){
        return ResponseEntity.ok(this.wishListService.isProductLiked(email, product));
    }


    @PostMapping("/add")
    public ResponseEntity<?> addProduct(
            @RequestBody WishListRequestDto wishListRequestDto
    ){
        WishList wishList = wishListMapper.toModel(wishListRequestDto);
        wishListService.addProduct(wishList);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/clean/{email}/{id}")
    public ResponseEntity<?> removeProduct(
            @PathVariable Long id,
            @PathVariable String email
    ){
        this.wishListService.removeProduct(id, email);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/cleanAll/{email}")
    public ResponseEntity<?> removeAllProducts(
            @PathVariable String email
    ){
        this.wishListService.cleanWishList(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
