package africa.exception;

public class WrongUserName extends RuntimeException {
    public WrongUserName(String message) {
        super(message);
    }
}
