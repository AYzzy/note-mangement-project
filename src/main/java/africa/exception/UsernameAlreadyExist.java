package africa.exception;

public class UsernameAlreadyExist extends RuntimeException {
    public UsernameAlreadyExist(String message) {
        super(message);
    }
}
