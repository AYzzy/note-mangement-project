package africa.exception;

public class UserNotFoundException extends ContactManagerException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
