package alexDavid.service;

import alexDavid.models.Activity;
import alexDavid.repository.ActivityRepository;
import alexDavid.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {

    private final ActivityRepository activityRepository;

    @Override
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(Long id) {
        return activityRepository.findById(id).get();
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
        Activity activity = activityRepository.findById(id).get();
        return Duration.between(activity.getTime_starts(), activity.getTime_ends());
    }
}
