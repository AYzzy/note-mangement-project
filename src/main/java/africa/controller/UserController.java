package africa.controller;

import africa.dto.Request.*;
import africa.dto.Response.*;
import africa.exception.ContactManagerException;
import africa.service.NoteService;
import africa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CREATED;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notes")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private NoteService noteService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try {
            RegisterResponse response = userService.register(registerUserRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginUserRequest loginUserRequest) {
        try {
            LoginResponse response = userService.login(loginUserRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutUserRequest logoutUserRequest) {
        try {
            LogoutResponse response = userService.logout(logoutUserRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }

    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UpdateUserRequest updateUserRequest) {
        try {
            UpdateResponse response = userService.update(updateUserRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteUserRequest deleteUserRequest) {
        try {
            DeleteResponse response = userService.delete(deleteUserRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CreateRequest createRequest) {
        try {
            CreateResponse response = noteService.create(createRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/edit")
    public ResponseEntity<?> edit(@RequestBody EditRequest editRequest) {
        try {
            EditResponse response = noteService.edit(editRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/locked")
    public ResponseEntity<?> locked(@RequestBody LockRequest lockRequest) {
        try {
            LockResponse response = noteService.locked(lockRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/unlocked")
    public ResponseEntity<?> unlocked(@RequestBody UnlockedRequest unlockedRequest) {
        try {
            UnlockResponse response = noteService.unlocked(unlockedRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteNoteRequest deleteNoteRequest) {
        try {
            DeleteNoteResponse response = noteService.delete(deleteNoteRequest);
            return new ResponseEntity<>(new APIResponse(true, response), CREATED);
        } catch (ContactManagerException e) {
            return new ResponseEntity<>(new APIResponse(false, e.getMessage()), BAD_REQUEST);
        }
    }


}