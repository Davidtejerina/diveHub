package alexDavid.mappers;

import alexDavid.dtos.ActivityDTO.ActivityResponseDto;
import alexDavid.models.Activity;
import org.springframework.stereotype.Component;
import alexDavid.dtos.ActivityDTO.ActivityResponseDto;

@Component
public class ActivityMapper {

    public ActivityResponseDto toResponse(Activity activity){
        return  new ActivityResponseDto(
                activity.getId(),
                activity.getName(),
                activity.getDescription(),
                activity.getStarting_price(),
                activity.getFinal_price(),
                activity.getImage(),
                activity.getCategory(),
                activity.getTag(),
                activity.getLevel_required(),
                activity.getTime_starts(),
                activity.getTime_ends(),
                activity.getAvailable_spaces(),
                activity.getAvailable()
        );
    }
}
