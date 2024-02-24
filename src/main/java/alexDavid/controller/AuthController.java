package alexDavid.controller;

import alexDavid.Auth.JwtService;
import alexDavid.Auth.LoginRequest;
import alexDavid.Auth.SignupRequest;
import alexDavid.models.User.User;
import alexDavid.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RequiredArgsConstructor
@RestController
@RequestMapping("/divehub/auth")
@Slf4j
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest loginRequest
    ) {
        log.info("hola1");
        log.info("Detalles de autenticación - Usuario: {}, Contraseña: {}", loginRequest.getEmail(), loginRequest.getPassword());
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getPassword()

            ));

            log.info("Autenticación exitosa");

            return ResponseEntity.ok(Map.of("token",
                    jwtService.createToken(loginRequest.getEmail())
            ));
        } catch (AuthenticationException e) {
            log.error("Error de autenticación: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autenticación: " + e.getMessage());
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
//        if(userDetailsService)
        User user= userDetailsService.create(signupRequest);

        return ResponseEntity.ok(Map.of("token",
                jwtService.createToken(user.getEmail()
                ))
        );
    }
}
