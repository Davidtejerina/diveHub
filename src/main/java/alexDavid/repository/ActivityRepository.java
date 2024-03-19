package alexDavid.repository;

import alexDavid.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByAvailable(Boolean available);
    List<Activity> findByNameContainsIgnoreCase(String name);
}
