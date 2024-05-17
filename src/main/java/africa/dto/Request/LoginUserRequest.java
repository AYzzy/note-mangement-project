package africa.dto.Request;

import lombok.Data;

@Data
public class LoginUserRequest {
    public boolean isLogin ;
    private String username;
    private String password;
}
