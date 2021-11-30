package be.intecbrussel.sellers;

public class NoMoreIcecreamException extends RuntimeException {

    public NoMoreIcecreamException() {
        super();
    }

    public NoMoreIcecreamException(String message) {
        super(message);
    }
}
