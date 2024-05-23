package africa.dto.utility;

import africa.data.model.Note;
import africa.data.model.User;
import africa.dto.Request.*;
import africa.dto.Response.*;

public class Mapper {
    public static CreateResponse mapCreateResponse(Note note){
        CreateResponse createResponse = new CreateResponse();
        createResponse.setId(note.getId());
        createResponse.setMessage("Note created Successfully");
        createResponse.setTitle(note.getTitle());
        return createResponse;


    }
    public static EditResponse mapEditResponse(Note note){
        EditResponse editResponse = new EditResponse();
        editResponse.setMessage("NOTE EDITED");
        return editResponse;
    }
    public static LockResponse mapLockResponse(Note note){
        LockResponse lockResponse = new LockResponse();
        lockResponse.setTitle(note.getTitle());
        lockResponse.setMessage("NOTE IS SUCCESSFULLY LOCKED");
        return lockResponse;
    }
    public static UnlockResponse mapUnlockResponse(Note note){
        UnlockResponse unlockResponse = new UnlockResponse();
        unlockResponse.setTitle(note.getTitle());
        unlockResponse.setMessage("NOTE IS SUCCESSFULLY UNLOCKED");
        return unlockResponse;
    }
    public static DeleteNoteResponse mapDeleteNoteResponse(Note note){
        DeleteNoteResponse deleteNoteResponse = new DeleteNoteResponse();
        deleteNoteResponse.setMessage("NOTE SUCCESSFULLY DELETED");
        return deleteNoteResponse;
    }
    public static RegisterResponse mapRegisterResponse(RegisterUserRequest registerUserRequest){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setId(registerUserRequest.getId());
        registerResponse.setUsername(registerUserRequest.getUsername());
        registerResponse.setMessage("YOU ARE SUCCESSFULLY REGISTERED");
        return registerResponse;
    }
    public  static LoginResponse mapLoginResponse(LoginUserRequest loginUserRequest){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(loginUserRequest.getUsername());
        loginResponse.setMessage("YOU HAVE SUCCESSFULLY LOGGED IN");
        return loginResponse;
    }
    public static LogoutResponse mapLogoutResponse(LogoutUserRequest logoutUserRequest){
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setUsername(logoutUserRequest.getUsername());
        logoutResponse.setMessage("LOGOUT SUCCESSFUL");
        return logoutResponse;
    }
}
