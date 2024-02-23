package alexDavid.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsService extends JpaRepository<User, Long> {
}
