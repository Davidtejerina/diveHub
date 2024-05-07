package alexDavid.dtos.AssessmentDTO;

import alexDavid.models.User.User;
import lombok.Data;

@Data
public class AssessmentRequestDto {
    private final User user;
    private final String content;
    private final Integer stars;
    private final Long productId;
}
