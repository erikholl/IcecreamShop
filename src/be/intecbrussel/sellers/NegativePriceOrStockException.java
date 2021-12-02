package be.intecbrussel.sellers;

public class NegativePriceOrStockException extends RuntimeException {

    public NegativePriceOrStockException(String message) {
        super(message);
    }

}
