package africa.service;

import africa.dto.Request.LoginUserRequest;
import africa.dto.Request.LogoutUserRequest;
import africa.exception.InvalidPasswordInputException;
import africa.exception.UsernameAlreadyExist;
import lombok.RequiredArgsConstructor;
import africa.data.repository.UserRepository;
import africa.dto.Request.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();
    }

    @Test
    void register() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("louis");
        registerUserRequest.setLastName("jane");
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());
    }
    @Test
    void testThatUserExist(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("louis");
        registerUserRequest.setLastName("jane");
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());

        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        registerUserRequest1.setFirstName("tolu");
        registerUserRequest1.setLastName("new");
        registerUserRequest1.setUsername("user1");
        registerUserRequest1.setPassword("112233");
        assertThrows(UsernameAlreadyExist.class,()-> userService.register(registerUserRequest1));

    }
    @Test
    void login(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("louis");
        registerUserRequest.setLastName("jane");
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("user1");
        loginUserRequest.setPassword("112233");
        userService.login(loginUserRequest);
        assertEquals(1, userRepository.count());

    }
    @Test
    void loginWithWrongPassword(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("louis");
        registerUserRequest.setLastName("jane");
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("user1");
        loginUserRequest.setPassword("11223");
        assertThrows(InvalidPasswordInputException.class,()->userService.login(loginUserRequest));
    }
    @Test
    void testToLoginWithUpperCase(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("louis");
        registerUserRequest.setLastName("jane");
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("useR1");
        loginUserRequest.setPassword("112233");
        userService.login(loginUserRequest);
        assertEquals(1,userRepository.count());

    }
    @Test
    void testToLogout(){
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("louis");
        registerUserRequest.setLastName("jane");
        registerUserRequest.setUsername("user1");
        registerUserRequest.setPassword("112233");
        userService.register(registerUserRequest);
        assertEquals(1, userRepository.count());
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setUsername("useR1");
        loginUserRequest.setPassword("112233");
        userService.login(loginUserRequest);
        assertEquals(1,userRepository.count());
        LogoutUserRequest logoutUserRequest = new LogoutUserRequest();
        logoutUserRequest.setUsername("user1");
        userService.logout(logoutUserRequest);
        assertEquals(1, userRepository.count());
    }



}