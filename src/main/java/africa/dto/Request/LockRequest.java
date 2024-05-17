package africa.dto.Request;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class LockRequest {
    private String id;
    private String title;
    private String password;
    private boolean isLocked;
}
