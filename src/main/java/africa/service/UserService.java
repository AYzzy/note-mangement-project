package africa.service;

import africa.dto.Request.*;
import africa.dto.Response.*;


public interface UserService {
    RegisterResponse register (RegisterUserRequest registerUserRequest);
    LoginResponse login(LoginUserRequest loginUserRequest);
    LogoutResponse logout(LogoutUserRequest logoutUserRequest);
    UpdateResponse update(UpdateUserRequest updateUserRequest);
    DeleteResponse delete(DeleteUserRequest deleteUserRequest);
    userNotesResponse FindAllNoteByUser(UserNoteRequest userNoteRequest);
}
