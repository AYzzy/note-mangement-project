package africa.dto.Request;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class EditRequest {

    private String id;
    private String title;
    private String user;
    private String body;
    private String newTitle;
    private String newBody;
}
