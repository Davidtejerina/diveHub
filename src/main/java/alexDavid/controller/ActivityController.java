package alexDavid.controller;

import alexDavid.dtos.ActivityDTO.ActivityResponseDto;
import alexDavid.mappers.ActivityMapper;
import alexDavid.service.ActivityService;
import alexDavid.models.Activity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import alexDavid.service.ActivityService;
import alexDavid.mappers.ActivityMapper;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/divehub/activities")
@RequiredArgsConstructor
@Slf4j
public class ActivityController {
    private final ActivityService activityService;
    private final ActivityMapper activityMapper;

    @GetMapping
    public ResponseEntity<List<ActivityResponseDto>> getAllActivities(

    ) {
        log.info("getAllActivities");
        return ResponseEntity.ok(
                activityMapper.toResponse(activityService.findAll())
        );
    }

    @GetMapping("/available")
    public ResponseEntity<List<ActivityResponseDto>> getAllAvailableActivities(
    ){
        log.info("getAllAvailableActivities");
        return ResponseEntity.ok(activityMapper.toResponse(activityService.findByAvailable())
        );

    }

    @GetMapping("/available_spaces/{id}")
    public ResponseEntity<Integer> getAllAvailable_spacesByActivityId(
            @PathVariable Long id
    ){
        log.info("getAllAvailable_spacesByActivityId");
        return ResponseEntity.ok(activityService.findById(id).getAvailable_spaces());
    }

    @GetMapping("/remaining-time/{id}")
    public ResponseEntity<Duration> getRemainingTimeByActivityId(
            @PathVariable Long id
    ){
        log.info("getTimeRemainingByActivityId");
        return ResponseEntity.ok(activityService.getRemainingTime(id)); //en horas
    }
}