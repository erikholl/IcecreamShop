package be.intecbrussel.sellers;

public class NoMoreIcecreamException extends RuntimeException {
    public NoMoreIcecreamException() {
        super();
    }

    public NoMoreIcecreamException (String message) {
        super(message);
    }

    public NoMoreIcecreamException (String message, Throwable cause) {
        super(message, cause);
    }

    public NoMoreIcecreamException (Throwable cause) {
        super(cause);
    }
}
