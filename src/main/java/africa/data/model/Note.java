package africa.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Note {
    @Id
    private String id;
    private String title;
    private String User;
    private String body;
    private String password;
    private boolean isLocked;

}

