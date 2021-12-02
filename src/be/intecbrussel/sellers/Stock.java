package be.intecbrussel.sellers;

public class Stock {

    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    public Stock() {
        this(0, 0, 0, 0);
    }

    public Stock(int iceRockets, int magni, int balls,
                 int cones) throws NegativePriceOrStockException {
        setIceRockets(iceRockets);
        setMagni(magni);
        setBalls(balls);
        setCones(cones);
    }

    public void setIceRockets(
            int iceRockets) throws NegativePriceOrStockException {
        if (iceRockets < 0)
            throw new NegativePriceOrStockException("negative" +
                                                            " IceRocket stock not allowed.");
        else
            this.iceRockets = iceRockets;
    }

    public void setMagni(int magni) throws NegativePriceOrStockException {
        if (magni < 0)
            throw new NegativePriceOrStockException("negative " +
                                                            "Magni" +
                                                            " " +
                                                            "stock" +
                                                            " not " +
                                                            "allowed");
        else
            this.magni = magni;
    }

    public void setBalls(int balls) throws NegativePriceOrStockException {
        if (balls < 0)
            throw new NegativePriceOrStockException("negative ball" +
                                                            " " +
                                                            "stock" +
                                                            " not " +
                                                            "allowed.");
        else
            this.balls = balls;
    }

    public void setCones(int cones) throws NegativePriceOrStockException {
        if (cones < 0)
            throw new NegativePriceOrStockException("negative cone" +
                                                            " " +
                                                            "stock" +
                                                            " not " +
                                                            "allowed.");
        else
            this.cones = cones;
    }

    public int getIceRockets() {
        return iceRockets;
    }

    public int getMagni() {
        return magni;
    }

    public int getBalls() {
        return balls;
    }

    public int getCones() {
        return cones;
    }

}
