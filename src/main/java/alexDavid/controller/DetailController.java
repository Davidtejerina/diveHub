package alexDavid.controller;

import alexDavid.dtos.DetailDto.DetailRequestDto;
import alexDavid.dtos.DetailDto.DetailResponseDto;
import alexDavid.mappers.DetailMapper;
import alexDavid.models.Detail;
import alexDavid.service.DetailService.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/divehub/details")
public class DetailController {
    private final DetailService detailService;
    private final DetailMapper detailMapper;


    @GetMapping("/{email}")
    public ResponseEntity<List<Detail>> getDetailsByUser(
            @PathVariable String email
    ){
        return ResponseEntity.ok(detailService.findByUser(email));
    }


    @PostMapping("/addDetail")
    public ResponseEntity<DetailResponseDto> postDetails(
            @RequestBody DetailRequestDto detailRequestDto
    ){
        Detail detail = detailService.addDetail(detailMapper.toModel(detailRequestDto));
        DetailResponseDto detailResponseDto = detailMapper.toResponse(detail);
        return ResponseEntity.ok(detailResponseDto);
    }


    @DeleteMapping("/clean/{email}")
    public ResponseEntity<?> removeDetails(
            @PathVariable String email
    ){
        detailService.deleteByUser(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
