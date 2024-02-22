package alexDavid.repository;

import alexDavid.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
