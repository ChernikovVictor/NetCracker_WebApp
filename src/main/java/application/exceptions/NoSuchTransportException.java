package application.exceptions;

public class NoSuchTransportException extends Exception {
    public NoSuchTransportException() {
        super();
    }

    public NoSuchTransportException(String message) {
        super(message);
    }

    public NoSuchTransportException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchTransportException(Throwable cause) {
        super(cause);
    }
}
