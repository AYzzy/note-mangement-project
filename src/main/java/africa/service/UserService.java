package africa.service;

import africa.data.model.Note;
import africa.data.model.User;
import africa.dto.Request.*;
import africa.dto.Response.*;

import java.util.List;


public interface UserService {
    RegisterResponse register (RegisterUserRequest registerUserRequest);
    LoginResponse login(LoginUserRequest loginUserRequest);
    LogoutResponse logout(LogoutUserRequest logoutUserRequest);
    UpdateResponse update(UpdateUserRequest updateUserRequest);
    DeleteResponse delete(DeleteUserRequest deleteUserRequest);
    List<Note> getUserNotes(String username);
}
