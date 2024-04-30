package alexDavid.repository;

import alexDavid.models.Detail;
import alexDavid.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Long> {
    List<Detail> findByOrder_User_Email(String userEmail);
    void deleteByOrder_User_Email(String email);
}
