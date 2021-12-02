package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Magnum;

public class PriceList {

    private double ballPrice;
    private double rocketPrice;
    private double magnumStandardPrice;

    public PriceList() {
        this(0, 0, 0);
    }

    public PriceList(double ballPrice, double rocketPrice,
                     double magnumStandardPrice) throws NegativePriceOrStockException {
        setBallPrice(ballPrice);
        setRocketPrice(rocketPrice);
        setMagnumStandardPrice(magnumStandardPrice);
    }

    public void setBallPrice(double ballPrice) throws NegativePriceOrStockException {
        if (ballPrice < 0) throw new NegativePriceOrStockException(
                "negative ballPrice not allowed.");
        else this.ballPrice = ballPrice;
    }

    public void setRocketPrice(double rocketPrice) throws NegativePriceOrStockException {
        if (rocketPrice < 0) throw new NegativePriceOrStockException(
                "negative rocketPrice not allowed.");
        else this.rocketPrice = rocketPrice;
    }

    public void setMagnumStandardPrice(double magnumStandardPrice) throws NegativePriceOrStockException {
        if (magnumStandardPrice < 0) throw new NegativePriceOrStockException(
                "negative magnumStandardPrice not allowed.");
        else this.magnumStandardPrice = magnumStandardPrice;
    }

    public double getBallPrice() {
        return ballPrice;
    }

    public double getRocketPrice() {
        return rocketPrice;
    }

    public double getMagnumPrice(Magnum.MagnumType type) {
        return magnumStandardPrice * type.getStandardPriceMultiplier();
    }
}
