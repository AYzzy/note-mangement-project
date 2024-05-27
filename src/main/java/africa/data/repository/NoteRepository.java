package africa.data.repository;

import africa.data.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface NoteRepository extends MongoRepository<Note, String> {
    Note findNoteById(String id);

    Optional<List<Note>> findNoteByTitle(String title);

    List<Note> getNotesByUsernameIgnoreCase(String username);
}
