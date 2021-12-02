package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller {

    private PriceList priceList;
    private Stock stock;
    private double profit;

    public IceCreamCar() {
        this(new PriceList(), new Stock());
    }

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    @Override
    public Cone orderCone(
            Cone.Flavor[] flavors) throws NoMoreIcecreamException {

        try {
            return prepareCone(flavors);
        } catch (NoMoreIcecreamException nmie) {
            System.out.println("Missing in stock: " + nmie.getMessage());
            return null;    // exception thrown, return null for orderCone;
                            // null will be used in app to remove from eatables
        }
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {
        int stockCones = stock.getCones();
        int stockBalls = stock.getBalls();

        if (stockCones == 0) {
            throw new NoMoreIcecreamException("No more cones. Sorry!");
        } else if (stockBalls == 0) {
            throw new NoMoreIcecreamException("No more balls. Sorry!");
        } else if (stockBalls < flavors.length) {
            throw new NoMoreIcecreamException(
                    "We only have " + stockBalls + " balls left. You ordered " + flavors.length + " balls.");
        } else {
            Cone yourCone = new Cone(flavors);
            stock.setCones(stockCones - 1);
            stock.setBalls(stockBalls - flavors.length);
            profit += flavors.length * priceList.getBallPrice();
            System.out.println(yourCone + " ordered!");
            return yourCone;
        }
    }

    @Override
    public IceRocket orderIceRocket() throws NoMoreIcecreamException {

        try {
            return prepareRocket();
        } catch (NoMoreIcecreamException nmie) {
            System.out.println("Missing in stock: " + nmie.getMessage());
            return null;    // see null explanation at orderCone
        }
    }

    private IceRocket prepareRocket() {
        int stockIceRockets = stock.getIceRockets();

        if (stockIceRockets == 0) {
            throw new NoMoreIcecreamException("No more IceRockets. Sorry!");
        } else {
            IceRocket yourRocket = new IceRocket();
            profit += priceList.getRocketPrice();
            stock.setIceRockets(stockIceRockets - 1);
            System.out.println(yourRocket + " ordered!");
            return yourRocket;
        }
    }

    @Override
    public Magnum orderMagnum(
            Magnum.MagnumType type) throws NoMoreIcecreamException {

        try {
            return prepareMagnum(type);
        } catch (NoMoreIcecreamException nmie) {
            System.out.println("Missing in stock: " + nmie.getMessage());
            return null; // see null explanation at orderCone
        }
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) {
        int stockMagnum = stock.getMagni();

        if (stockMagnum < 1) {
            throw new NoMoreIcecreamException("No more Magnums. Sorry!");
        } else {
            Magnum yourMagnum = new Magnum(type);
            profit += priceList.getMagnumPrice(type);
            stock.setMagni(stockMagnum - 1);
            System.out.println(yourMagnum + " ordered!");
            return yourMagnum;
        }
    }

    @Override
    public double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return String.format(
                "\nWelcome to Mario's ice cream kart. Prices are %.2f " +
                        "for a normal Magnum, %.2f for 1 ball " +
                        "and %.2f for an IceRocket. \nCurrent stock: %d " +
                        "Magnum(s), %d ball(s) of ice, %d cone(s) and %d " +
                        "IceRocket(s).\n",
                priceList.getMagnumPrice(Magnum.MagnumType.BLACKCHOCOLATE),
                priceList.getBallPrice(), priceList.getRocketPrice(),
                stock.getMagni(), stock.getBalls(), stock.getCones(),
                stock.getIceRockets());
    }

}
