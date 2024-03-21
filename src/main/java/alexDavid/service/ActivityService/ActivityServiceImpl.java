package alexDavid.service.ActivityService;

import alexDavid.models.Activity;
import alexDavid.repository.ActivityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(Long id) {
        return activityRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Activity> findByName(String name){
        return activityRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public Activity save(Activity activity) {
       return activityRepository.save(activity);
    }

    @Override
    public List<Activity> findByAvailable() {
        return activityRepository.findAllByAvailable(true);
    }

    @Override
    public Duration getRemainingTime(Long id){
        Activity activity = activityRepository.findById(id).orElseThrow();
        return Duration.between(activity.getTime_starts(), activity.getTime_ends());
    }
}
