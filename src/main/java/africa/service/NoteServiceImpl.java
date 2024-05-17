package africa.service;

import africa.data.model.Note;
import africa.data.repository.NoteRepository;
import africa.dto.Request.*;
import africa.dto.Response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import africa.exception.*;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.dto.utility.Mapper.*;

@Service
public class NoteServiceImpl implements NoteService{
    @Autowired
    NoteRepository noteRepository;

    @Override
    public CreateResponse create(CreateRequest createRequest) {

        Note note = new Note();
        if(createRequest.getTitle().isEmpty())throw new TitleEmptyException("TITLE IS EMPTY");
        if(createRequest.getBody().isEmpty())throw new BodyEmptyException("BODY IS EMPTY");
        note.setUser(createRequest.getUser());
        note.setTitle(createRequest.getTitle().toLowerCase());
        note.setBody(createRequest.getBody());
        noteRepository.save(note);

       return mapCreateResponse(note);
    }

    @Override
    public EditResponse edit(EditRequest editRequest) {
        Note note = findNoteById(editRequest.getId());
        if(editRequest.getNewTitle().isEmpty())
            throw new TitleEmptyException("OGA INPUT A NEW TITLE");
        if(editRequest.getNewBody().isEmpty())
            throw new BodyEmptyException("Oga input a new body");

        note.setUser(editRequest.getUser());
        note.setTitle(editRequest.getNewTitle().toLowerCase());
        note.setBody(editRequest.getNewBody());
        noteRepository.save(note);

        return mapEditResponse(note);
    }

    @Override
    public LockResponse locked(LockRequest lockRequest) {
        Note note = findNoteById(lockRequest.getId());
        note.setTitle(lockRequest.getTitle().toLowerCase());
        note.setPassword(lockRequest.getPassword());
        note.setLocked(true);
        noteRepository.save(note);

        return mapLockResponse(note);
    }

    @Override
    public UnlockResponse unlocked(UnlockedRequest unlockedRequest) {
        Note note = findNoteById(unlockedRequest.getId());
        if(!note.getPassword().equals(unlockedRequest.getPassword())){
            throw new InvalidPasswordInputException("invalid password, please enter password");
        }
        note.setTitle(unlockedRequest.getTitle().toLowerCase());
        note.setLocked(false);
        noteRepository.save(note);

        return mapUnlockResponse(note);
    }

    @Override
    public List<Note> findById(String id) {
        return List.of(noteRepository.findNoteById(id));
    }

    @Override
    public List<Note> findByTitle(String title) {
        return noteRepository.findNoteByTitle(title)
                .orElseThrow(()->  new NoteNotFoundException("title not found "));
    }

    @Override
    public List<Note> findAllNote() {
        return noteRepository.findAll();
    }


    @Override
    public DeleteNoteResponse deleteNote(DeleteNoteRequest deleteNoteRequest) {
        Note note = findNoteById(deleteNoteRequest.getId());
        noteRepository.delete(note);

        return mapDeleteNoteResponse(note);
    }

    private Note findNoteById(String id) {
        Note note = noteRepository.findNoteById(id);
        if(note == null) throw new NoteEmptyException("this user ain't found");
        return note;
    }
}
