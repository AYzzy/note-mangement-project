package africa.exception;

public class NoteEmptyException extends RuntimeException {
    public NoteEmptyException(String message) {
        super(message);
    }
}
