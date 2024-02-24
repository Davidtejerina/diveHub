package alexDavid.Auth;


import alexDavid.models.Level;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SignupRequest {

    private String nickname;
    private String password;
    private String name;
    private String surnames;
    private String email;
    private LocalDateTime birthday;
    private String address;

}

