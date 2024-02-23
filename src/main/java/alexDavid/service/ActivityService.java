package alexDavid.service;

import alexDavid.models.Activity;

import java.util.List;

public interface ActivityService {

    List<Activity> findAll();
    void save(Activity activity);
}
