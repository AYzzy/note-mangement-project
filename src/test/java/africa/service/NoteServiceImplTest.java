package africa.service;

import africa.data.repository.NoteRepository;
import africa.data.repository.UserRepository;
import africa.dto.Request.*;
import africa.dto.Response.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class NoteServiceImplTest {
    @Autowired
    NoteService service;
    @Autowired
    private NoteRepository noteRepository;
    private UserRepository userRepository;


    @BeforeEach
    public void setUp(){
        noteRepository.deleteAll();
    }


    @Test
    void create() {
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTitle("the jokes");
        createRequest.setBody("that's the best of all");
        CreateResponse createResponse1 = service.create(createRequest);
        System.out.println(createResponse1);
        createRequest.setTitle("hello");
        createRequest.setBody("hello world");
        CreateResponse createResponse2 = service.create(createRequest);
        System.out.println(createResponse2);
        createRequest.setTitle("welcome");
        createRequest.setBody("it's a beautiful world");
        CreateResponse createResponse3 = service.create(createRequest);
        System.out.println(createResponse3);
        assertEquals(3,noteRepository.count());
    }

    @Test
    void edit() {
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTitle("the jokes");
        createRequest.setBody("that's the best of all");
        CreateResponse createResponse1 = service.create(createRequest);
        System.out.println(createResponse1);
        createRequest.setTitle("hello");
        createRequest.setBody("hello world");
        CreateResponse createResponse2 = service.create(createRequest);
        System.out.println(createResponse2);
        createRequest.setTitle("welcome");
        createRequest.setBody("it's a beautiful world");
        CreateResponse createResponse3 = service.create(createRequest);
        System.out.println(createResponse3);
        assertEquals(3,noteRepository.count());

        EditRequest editRequest = new EditRequest();
        editRequest.setId(createResponse2.getId());
        editRequest.setNewTitle("someday");
        editRequest.setNewBody("we go dey okay");
        EditResponse editResponse = service.edit(editRequest);
        System.out.println(editResponse);
        assertEquals(3,noteRepository.count());
        assertEquals(createResponse2.getId(), editResponse.getId());
    }

    @Test
    void locked() {
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTitle("the jokes");
        createRequest.setBody("that's the best of all");
        CreateResponse createResponse1 = service.create(createRequest);
        System.out.println(createResponse1);
        createRequest.setTitle("hello");
        createRequest.setBody("hello world");
        CreateResponse createResponse2 = service.create(createRequest);
        System.out.println(createResponse2);
        createRequest.setTitle("welcome");
        createRequest.setBody("it's a beautiful world");
        CreateResponse createResponse3 = service.create(createRequest);
        System.out.println(createResponse3);
        assertEquals(3,noteRepository.count());

        LockRequest lockRequest= new LockRequest();
        lockRequest.setId(createResponse3.getId());
        lockRequest.setTitle("welcome");
        lockRequest.setPassword("1234567");
        LockResponse lockResponse = service.locked(lockRequest);
        System.out.println(lockResponse);
        assertTrue(noteRepository.findNoteById(lockRequest.getId()).isLocked());

    }

    @Test
    void unlocked() {
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTitle("the jokes");
        createRequest.setBody("that's the best of all");
        CreateResponse createResponse1 = service.create(createRequest);
        System.out.println(createResponse1);
        createRequest.setTitle("hello");
        createRequest.setBody("hello world");
        CreateResponse createResponse2 = service.create(createRequest);
        System.out.println(createResponse2);
        createRequest.setTitle("welcome");
        createRequest.setBody("it's a beautiful world");
        CreateResponse createResponse3 = service.create(createRequest);
        System.out.println(createResponse3);
        assertEquals(3,noteRepository.count());

        LockRequest lockRequest= new LockRequest();
        lockRequest.setId(createResponse3.getId());
        lockRequest.setTitle("welcome");
        lockRequest.setPassword("1234567");
        LockResponse lockResponse = service.locked(lockRequest);
        System.out.println(lockResponse);
        assertTrue(noteRepository.findNoteById(lockRequest.getId()).isLocked());

        UnlockedRequest unlockedRequest = new UnlockedRequest();
        unlockedRequest.setId(createResponse3.getId());
        unlockedRequest.setTitle(createResponse3.getTitle());
        unlockedRequest.setPassword(lockRequest.getPassword());
        UnlockResponse unlockResponse = service.unlocked(unlockedRequest);
        System.out.println(unlockResponse);
        assertFalse(noteRepository.findNoteById(unlockedRequest.getId()).isLocked());
    }


    @Test
    void delete() {
        CreateRequest createRequest = new CreateRequest();
        createRequest.setTitle("the jokes");
        createRequest.setBody("that's the best of all");
        CreateResponse createResponse1 = service.create(createRequest);
        System.out.println(createResponse1);
        createRequest.setTitle("hello");
        createRequest.setBody("hello world");
        CreateResponse createResponse2 = service.create(createRequest);
        System.out.println(createResponse2);
        createRequest.setTitle("welcome");
        createRequest.setBody("it's a beautiful world");
        CreateResponse createResponse3 = service.create(createRequest);
        System.out.println(createResponse3);
        assertEquals(3,noteRepository.count());

        DeleteNoteRequest deleteNoteRequest = new DeleteNoteRequest();
        deleteNoteRequest.setId(createResponse3.getId());
        DeleteNoteResponse deleteNoteResponse = service.delete(deleteNoteRequest);
        System.out.println(deleteNoteResponse);
        deleteNoteRequest.setId(createResponse1.getId());
        DeleteNoteResponse deleteNoteResponse2 = service.delete(deleteNoteRequest);
        System.out.println(deleteNoteResponse2);
        assertEquals(1, noteRepository.count());
    }
}