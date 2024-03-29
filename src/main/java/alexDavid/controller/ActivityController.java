package alexDavid.controller;

import alexDavid.dtos.ActivityDTO.ActivityResponseDto;
import alexDavid.mappers.ActivityMapper;
import alexDavid.service.ActivityService.ActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/divehub/activities")
@RequiredArgsConstructor
@CrossOrigin
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityMapper activityMapper;

    @GetMapping("/all")
    public ResponseEntity<List<ActivityResponseDto>> getAllActivities(

    ) {
        return ResponseEntity.ok(activityMapper.toResponse(activityService.findAll()));
    }

    @GetMapping("/getActivityById/{id}")
    public ResponseEntity<ActivityResponseDto> getActivityById(
        @PathVariable Long id
    ) {
        return ResponseEntity.ok(activityMapper.toResponse(activityService.findById(id)));
    }

    @GetMapping("/getActivityByName/{name}")
    public ResponseEntity<List<ActivityResponseDto>> getActivityByName(
            @PathVariable String name
    ) {
        return ResponseEntity.ok(activityMapper.toResponse(activityService.findByName(name)));
    }

    @GetMapping("/available")
    public ResponseEntity<List<ActivityResponseDto>> getAllAvailableActivities(
    ){
        return ResponseEntity.ok(activityMapper.toResponse(activityService.findByAvailable()));
    }

    @GetMapping("/available_spaces/{id}")
    public ResponseEntity<Integer> getAllAvailable_spacesByActivityId(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(activityService.findById(id).getAvailable_spaces());
    }

    @GetMapping("/remaining-time/{id}")
    public ResponseEntity<Duration> getRemainingTimeByActivityId(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(activityService.getRemainingTime(id)); //en horas
    }
}
