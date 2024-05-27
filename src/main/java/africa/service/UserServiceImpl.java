package africa.service;

import africa.data.model.Note;
import africa.data.model.User;
import africa.data.repository.NoteRepository;
import africa.data.repository.UserRepository;
import africa.dto.Request.*;
import africa.dto.Response.*;
import africa.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.dto.utility.Mapper.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    NoteRepository noteRepository;


    @Override
    public RegisterResponse register(RegisterUserRequest registerUserRequest) {
        alreadyExistingUser(registerUserRequest.getUsername().toLowerCase());
        User user= new User();
        user.setUsername(registerUserRequest.getUsername());
        user.setFirstName(registerUserRequest.getFirstName());
        user.setLastName(registerUserRequest.getLastName());
        user.setPassword(registerUserRequest.getPassword());
        userRepository.save(user);

        return mapRegisterResponse(registerUserRequest);
    }

    private void alreadyExistingUser(String username) {
        userRepository.findAll().forEach(user -> {if (user.getUsername().equals(username.toLowerCase()))
            throw new UsernameAlreadyExist("Already existing user...");
        });
    }

    @Override
    public LoginResponse login(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByUsername(loginUserRequest.getUsername().toLowerCase());
        if (user == null ) {
            throw new UserNotFoundException("User not found");
        }
        if(!user.getUsername().equals(loginUserRequest.getUsername().toLowerCase())) throw new UserDoseNotExist("user not found");
        if(!user.getPassword().equals(loginUserRequest.getPassword())){ throw new InvalidPasswordInputException("wrong password");}
        user.setIsLogin(true);
        userRepository.save(user);

        return mapLoginResponse(loginUserRequest);
    }

    @Override
    public LogoutResponse logout(LogoutUserRequest logoutUserRequest) {
        User user = userRepository.findByUsername(logoutUserRequest.getUsername().toLowerCase());
        user.setUsername(logoutUserRequest.getUsername().toLowerCase());
        user.setIsLogin(false);
        userRepository.save(user);

        return mapLogoutResponse(logoutUserRequest);
    }

    @Override
    public UpdateResponse update(UpdateUserRequest updateUserRequest) {
        User user = userRepository.findByUsername(updateUserRequest.getUsername().toLowerCase());

        user.setUsername(updateUserRequest.getNewUsername().toLowerCase());
        user.setPassword(updateUserRequest.getNewPassword());
        userRepository.save(user);

        UpdateResponse updateResponse = new UpdateResponse();
        updateResponse.setMessage("UPDATE SUCCESSFUL");


        return updateResponse;
    }

    @Override
    public DeleteResponse delete(DeleteUserRequest deleteUserRequest) {
        User user = findByUsername(deleteUserRequest.getUsername().toLowerCase());
        if(!user.getUsername().equals(deleteUserRequest.getUsername().toLowerCase())) throw new UserDoseNotExist("user not found");
        user.setUsername(deleteUserRequest.getUsername().toLowerCase());
        userRepository.delete(user);
        DeleteUserRequest deleteUserRequest1 = new DeleteUserRequest();
        user.setUsername(deleteUserRequest1.getUsername());

        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("YOU NO LONGER HAVE ACCESS TO THIS APP");
        return deleteResponse;
    }

    @Override
    public List<Note> getUserNotes(String username) {
        User user = findByUsername(username);
        user.setUsername(username);
        userRepository.save(user);

        return noteRepository.getNotesByUsernameIgnoreCase(username);

    }



    private User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)throw new UserDoseNotExist("User Doesn't Exist");
        return user;
    }
}
