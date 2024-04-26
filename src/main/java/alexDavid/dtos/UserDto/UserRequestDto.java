package alexDavid.dtos.UserDto;

import alexDavid.models.Level;
import alexDavid.models.User.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
public class UserRequestDto {
    private final String nickname;
    private final String password;
    private final String name;
    private final String surnames;
    private final String email;
    private final Integer phone;
    private final LocalDateTime birthday;
    private final String address;
    private final Level level;
}
