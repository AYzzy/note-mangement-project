package africa.dto.Response;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CreateResponse {

    private String id;
    private String message;
    private String title;
}
