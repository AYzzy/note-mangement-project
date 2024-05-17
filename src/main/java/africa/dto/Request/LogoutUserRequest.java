package africa.dto.Request;

import lombok.Data;

@Data
public class LogoutUserRequest {
    public String username;
    public boolean isLogin ;
}