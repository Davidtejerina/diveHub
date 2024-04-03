package alexDavid.service.ActivityService;

import alexDavid.models.Activity;
import alexDavid.models.Category;
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
    public List<Activity> findProductsByTagIgnoreCase(String tag) {
        return activityRepository.findProductsByTagIgnoreCase(tag);
    }

    @Override
    public List<Activity> findProductsByCategory(Integer categoryIndex) {
        Category[] categories = Category.values();
        if (categoryIndex >= 0 && categoryIndex < categories.length) {
            Category category = categories[categoryIndex];
            return activityRepository.findByCategory(category);
        }
        else throw new IllegalArgumentException("Índice de categoría inválido: " + categoryIndex);
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
