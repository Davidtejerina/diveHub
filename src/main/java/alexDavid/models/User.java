package alexDavid.models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="user_")
public class User implements UserDetails {
    @Id
    private Long id;
    private String nickname;
    private String password;
    private String name;
    private String surnames;
    private String email;
    private LocalDateTime birthday;
    private String address;
    private Integer level;
    private LocalDateTime registration_date;
    private LocalDateTime last_login;
    private Long cookie;
    private LocalDateTime cookie_expiration;
    private Integer role;

    public User(Long id, String nickname, String password, String name, String surnames,
                String email, LocalDateTime birthday, String address, Integer level,
                LocalDateTime registration_date, LocalDateTime last_login, Long cookie,
                LocalDateTime cookie_expiration, Integer role) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.name = name;
        this.surnames = surnames;
        this.email = email;
        this.birthday = birthday;
        this.address = address;
        this.level = level;
        this.registration_date = registration_date;
        this.last_login = last_login;
        this.cookie = cookie;
        this.cookie_expiration = cookie_expiration;
        this.role = role;
    }
}
