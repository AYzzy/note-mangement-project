package africa.exception;

public class InvalidPasswordInputException extends RuntimeException {
    public InvalidPasswordInputException(String message) {
        super(message);
    }
}
