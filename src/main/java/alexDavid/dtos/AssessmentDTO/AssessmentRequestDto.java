package alexDavid.dtos.AssessmentDTO;

import alexDavid.models.User.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AssessmentRequestDto {
    private final User user;
    private final String content;
    private final Integer stars;
    private final Long productId;
    private final LocalDateTime date;
}
