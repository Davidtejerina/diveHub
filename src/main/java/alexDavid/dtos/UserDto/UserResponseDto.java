package alexDavid.dtos.UserDto;

import alexDavid.models.Level;
import alexDavid.models.User.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
public class UserResponseDto {
    private final Long id;
    private final String nickname;
    private final String password;
    private final String name;
    private final String surnames;
    private final String email;
    private final Integer phone;
    private final LocalDateTime birthday;
    private final String address;
    private final Level level;
    private final LocalDateTime registration_date;
    private final LocalDateTime last_login;
    private final Role role;
}
