package africa.exception;

public class EmptyUsernameException extends ContactManagerException {
    public EmptyUsernameException(String message) {
        super(message);
    }
}
