package alexDavid.mappers;

import alexDavid.dtos.ActivityDTO.ActivityResponseDto;
import alexDavid.dtos.ProductDTO.ProductResponseDto;
import alexDavid.models.Activity;
import alexDavid.models.Product;
import org.springframework.stereotype.Component;
import alexDavid.dtos.ActivityDTO.ActivityResponseDto;

import java.util.List;

@Component
public class ActivityMapper {

    public ActivityResponseDto toResponse(Activity activity){
        return new ActivityResponseDto(
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
    public List<ActivityResponseDto> toResponse(List<Activity> activities) {
        return activities.stream().
                map(this::toResponse).
                toList();
    }
}
