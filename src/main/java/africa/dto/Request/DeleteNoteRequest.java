package africa.dto.Request;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class DeleteNoteRequest {
    private String id;
    private String title;

}
