package africa.dto.Request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String newUsername;
    private String newPassword;
    private String username;
    private String password;
}
