package africa.data.repository;

import africa.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);

    void findNoteById(String id);
}
