package alexDavid.controller;

import alexDavid.Contact.MessageService;
import alexDavid.dtos.UserDTO.UserRequestDto;
import alexDavid.dtos.UserDTO.UserResponseDto;
import alexDavid.mappers.UserMapper;
import alexDavid.service.CartService.CartService;
import alexDavid.service.DetailService.DetailService;
import alexDavid.service.OrderService.OrderService;
import alexDavid.service.UserDetailsServiceImpl;
import alexDavid.service.WishListService.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/divehub/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    private final UserDetailsServiceImpl userService;
    private final WishListService wishListService;
    private final MessageService messageService;
    private final CartService cartService;
    private final DetailService detailService;
    private final UserMapper userMapper;
    private final OrderService orderService;


    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUser(
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.getAllUsers()));
    }


    @GetMapping("/{email}")
    public ResponseEntity<UserResponseDto> getUser(
            @PathVariable String email
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.loadUserByUserEmail(email)));
    }


    @GetMapping("/isAdmin/{email}")
    public ResponseEntity<Boolean> getUserIsAdmin(
            @PathVariable String email
    ) {
        return ResponseEntity.ok(userService.isAdmin(email));
    }


    @PutMapping("/{email}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable String email,
            @RequestBody UserRequestDto user
    ) {
        return ResponseEntity.ok(userMapper.toResponse(userService.updateUser(email, userMapper.toModel(user))));
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<?> deleteUser(
            @PathVariable String email
    ) {
        cartService.cleanCart(email);
        detailService.deleteByUser(email);
        orderService.deleteByUser(email);
        messageService.deleteAllMessages(email);
        wishListService.cleanWishList(email);
        userService.deleteUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


