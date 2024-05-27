package africa.service;

import africa.data.model.Note;
import africa.dto.Request.*;
import africa.dto.Response.*;


import java.util.List;

public interface NoteService {
    CreateResponse create (CreateRequest createRequest);
    EditResponse edit (EditRequest editRequest);
    LockResponse locked(LockRequest lockRequest);
    UnlockResponse unlocked(UnlockedRequest unlockedRequest);
    List<Note> findById (String id);
    List<Note> findByTitle(String title);
    List<Note> findAllNote();
    DeleteNoteResponse deleteNote(DeleteNoteRequest deleteNoteRequest);
}
