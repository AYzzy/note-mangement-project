package africa.service;

import africa.data.model.User;
import africa.data.repository.UserRepository;
import africa.dto.Request.*;
import africa.dto.Response.*;
import africa.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public RegisterResponse register(RegisterUserRequest registerUserRequest) {
        alreadyExistingUser(registerUserRequest.getUsername().toLowerCase());
        User user1= new User();
        user1.setUsername(registerUserRequest.getUsername());
        user1.setFirstName(registerUserRequest.getFirstName());
        user1.setLastName(registerUserRequest.getLastName());
        user1.setPassword(registerUserRequest.getPassword());
        userRepository.save(user1);

        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(registerResponse.getUsername());
        registerResponse.setMessage("YOU ARE SUCCESSFULLY REGISTERED");
        return registerResponse;
    }

    private void alreadyExistingUser(String username) {
        userRepository.findAll().forEach(user -> {if (user.getUsername().equals(username))throw new UsernameAlreadyExist("Already existing user...");});
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

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(loginResponse.getUsername());
        loginResponse.setMessage("YOU HAVE SUCCESSFULLY LOGGED IN");
        return loginResponse;
    }

    @Override
    public LogoutResponse logout(LogoutUserRequest logoutUserRequest) {
        User user = userRepository.findByUsername(logoutUserRequest.getUsername().toLowerCase());
        user.setUsername(logoutUserRequest.getUsername());
        user.setIsLogin(false);
        userRepository.save(user);

        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setUsername(logoutResponse.getUsername());
        logoutResponse.setMessage("LOGOUT SUCCESSFUL");
        return logoutResponse;
    }

    @Override
    public UpdateResponse update(UpdateUserRequest updateUserRequest) {
        User user = userRepository.findByUsername(updateUserRequest.getUsername().toLowerCase());

        user.setUsername(updateUserRequest.getNewUsername());
        user.setPassword(updateUserRequest.getNewPassword());
        userRepository.save(user);

        UpdateResponse updateResponse = new UpdateResponse();
        updateResponse.setMessage("UPDATE SUCCESSFUL");


        return updateResponse;
    }

    @Override
    public DeleteResponse delete(DeleteUserRequest deleteUserRequest) {
        User user = findByUsername(deleteUserRequest.getUsername().toLowerCase());
        userRepository.delete(user);
        DeleteUserRequest deleteUserRequest1 = new DeleteUserRequest();
        user.setUsername(deleteUserRequest1.getUsername());

        DeleteResponse deleteResponse = new DeleteResponse();
        deleteResponse.setMessage("YOU NO LONGER HAVE ACCESS TO THIS APP");
        return deleteResponse;
    }

    private User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)throw new UserDoseNotExist("User Doesn't Exist");
        return user;
    }
}
