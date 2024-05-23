package africa.exception;

public class WrongUserName extends ContactManagerException {
    public WrongUserName(String message) {
        super(message);
    }
}
