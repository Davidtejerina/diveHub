package alexDavid.repository;

import alexDavid.models.Activity;
import alexDavid.models.Order;
import alexDavid.models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser_Email(String userEmail);
    void deleteByUser_Email(String email);
}
