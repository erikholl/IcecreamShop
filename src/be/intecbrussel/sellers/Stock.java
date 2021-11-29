package be.intecbrussel.sellers;

public class Stock {

    // variables
    private int iceRockets;
    private int cones;
    private int balls;
    private int magni;

    // constructors
    public Stock() {
        this(0, 0, 0, 0);
    }

    public Stock(int iceRockets, int magni, int balls, int cones) {
        setIceRockets(iceRockets);
        setMagni(magni);
        setBalls(balls);
        setCones(cones);
    }

    public void setIceRockets(int iceRockets) {
        this.iceRockets = iceRockets;
    }

    public void setMagni(int magni) {
        this.magni = magni;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public void setCones(int cones) {
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
