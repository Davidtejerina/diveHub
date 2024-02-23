package alexDavid.service;

import alexDavid.models.Activity;
import alexDavid.repository.ActivityRepository;
import alexDavid.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
    public void save(Activity activity) {
       activityRepository.save(activity);
    }
}
