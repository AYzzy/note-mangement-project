package africa.dto.utility;

import africa.data.model.Note;
import africa.data.model.User;
import africa.dto.Request.DeleteNoteRequest;
import africa.dto.Request.EditRequest;
import africa.dto.Request.LockRequest;
import africa.dto.Request.UnlockedRequest;
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
        editResponse.setId(note.getId());
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
        unlockResponse.setId(note.getId());
        unlockResponse.setTitle(note.getTitle());
        unlockResponse.setMessage("NOTE IS SUCCESSFULLY UNLOCKED");
        return unlockResponse;
    }
    public static DeleteNoteResponse mapDeleteNoteResponse(Note note){
        DeleteNoteResponse deleteNoteResponse = new DeleteNoteResponse();
        deleteNoteResponse.setId(note.getId());
        deleteNoteResponse.setMessage("NOTE SUCCESSFULLY DELETED");
        return deleteNoteResponse;
    }
    public  static RegisterResponse mapRegisterResponse(User user){
        RegisterResponse registerResponse = new RegisterResponse();
        registerResponse.setUsername(user.getUsername());
        registerResponse.setMessage("YOU ARE SUCCESSFULLY REGISTERED");
        return registerResponse;
    }
    public  static LoginResponse mapLoginResponse(User user){
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(user.getUsername());
        loginResponse.setMessage("YOU HAVE SUCCESSFULLY LOGGED IN");
        return loginResponse;
    }
    public static LogoutResponse mapLogoutResponse(User user){
        LogoutResponse logoutResponse = new LogoutResponse();
        logoutResponse.setUsername(user.getUsername());
        logoutResponse.setMessage("LOGOUT SUCCESSFUL");
        return logoutResponse;
    }
}
