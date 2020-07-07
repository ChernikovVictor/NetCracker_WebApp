package application.exceptions;

public class TransportCreationException extends Exception {

    public TransportCreationException() {
        super();
    }

    public TransportCreationException(String message) {
        super(message);
    }

    public TransportCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransportCreationException(Throwable cause) {
        super(cause);
    }
}
