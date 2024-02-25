package alexDavid.dtos.UserDto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Builder
public class UserRequestDto {
    private final String nickname;
    private final String password;
    private final String name;
    private final String surnames;
    private final String email;
    private final LocalDateTime birthday;
    private final String address;
}
