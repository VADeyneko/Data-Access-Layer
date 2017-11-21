package exceptions;

public class PrimaryKeyViolationException extends Exception {

    public PrimaryKeyViolationException() {
    }

    public PrimaryKeyViolationException(String message) {
        super(message);
    }

    public PrimaryKeyViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrimaryKeyViolationException(Throwable cause) {
        super(cause);
    }

}
