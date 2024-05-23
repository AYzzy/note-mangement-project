package africa.exception;

public class NoteNotFoundException extends ContactManagerException {
    public NoteNotFoundException(String message) {
        super(message);
    }
}
