package africa.data.repository;

import africa.data.model.Note;
import africa.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    void findNoteById(String id);


}
