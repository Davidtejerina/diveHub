package alexDavid.service.ActivityService;

import alexDavid.models.Activity;

import java.time.Duration;
import java.util.List;

public interface ActivityService {
    List<Activity> findAll();
    Activity findById(Long id);
    Activity save(Activity activity);   //amarillo porq no se usa el save en el controller, no preocuparse
    List<Activity> findByAvailable();
    Duration getRemainingTime(Long id);
    List<Activity> findByName(String name);
}
