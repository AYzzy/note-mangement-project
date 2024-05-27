package africa.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Note")
@Data
public class Note {
    @Id
    private String id;
    private String title;
    private String User;
    private String body;
    private String password;
    private boolean isLocked;
    private String username;


}

