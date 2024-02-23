package alexDavid.mappers;

import alexDavid.dtos.UserDto.UserResponseDto;
import alexDavid.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto toResponse(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getNickname(),
                user.getPassword(),
                user.getName(),
                user.getSurnames(),
                user.getEmail(),
                user.getBirthday(),
                user.getAddress(),
                user.getLevel(),
                user.getRegistration_date(),
                user.getLast_login(),
                user.getCookie(),
                user.getCookie_expiration(),
                user.getRole()

        );
    }
    public User toModel(UserResponseDto userDto){
        return new User(
                null,
                userDto.getNickname(),
                userDto.getPassword(),
                userDto.getName(),
                userDto.getSurnames(),
                userDto.getEmail(),
                userDto.getBirthday(),
                userDto.getAddress(),
                userDto.getLevel(),
                userDto.getRegistration_date(),
                userDto.getLast_login(),
                userDto.getCookie(),
                userDto.getCookie_expiration(),
                userDto.getRole()
        );
    }
}
