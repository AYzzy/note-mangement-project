package africa.dto.utility;

import africa.data.model.Note;
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
}
