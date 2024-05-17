package africa.dto.Request;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class CreateRequest {
    private String user;
    private String id;
    private String title;
    private String body;
}