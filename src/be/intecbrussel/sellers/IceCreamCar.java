package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller {
    // variables
    private PriceList priceList = new PriceList();
    private Stock stock = new Stock();
    private double profit;

    // constructors

    public IceCreamCar() {
        this(new PriceList(), new Stock());
    }

    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    // TODO: extend cone methods to make diff between cones / balls shortage
    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
//        if (yourCone == null) {
//            throw new NoMoreIcecreamException("Out of Cones");
//        } else
        return prepareCone(flavors);
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {
        int stockCones = stock.getCones();
        int stockBalls = stock.getBalls();
        try {
            if (stockCones < 1) {
                throw new NoMoreIcecreamException("no more cones");
            }
        } catch (NoMoreIcecreamException noIceMessage) {
            System.out.println(noIceMessage);
        }
        Cone yourCone = new Cone(flavors);
        stock.setCones(stockCones - 1);
        profit += flavors.length * priceList.getBallPrice();
        return yourCone;
    }

//        if (stockCones >= 1 && stockBalls >= flavors.length) {
//            Cone yourCone = new Cone(flavors);
//            profit =
//                    profit + (flavors.length * (0.5 * priceList.getBallPrice()));
//            stock.setCones(stockCones - 1);
//            stock.setBalls(stockBalls - flavors.length);
//            return yourCone;
//        } else
//            return null;

    @Override
    public IceRocket orderIceRocket() {
        IceRocket yourRocket = prepareRocket();

        if (yourRocket == null) {
            throw new NoMoreIcecreamException("Out of IceRockets");
        } else
            return yourRocket;
    }

    private IceRocket prepareRocket() {
        int stockIceRockets = stock.getIceRockets();

        if (stockIceRockets >= 1) {
            IceRocket yourRocket = new IceRocket();
            profit = profit + (0.4 * priceList.getRocketPrice());
            stock.setIceRockets(stockIceRockets - 1);
            return yourRocket;
        } else
            return null;
    }

    // TODO?? relate stock to magnum type??
    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum yourMagnum = prepareMagnum(type);

        if (yourMagnum == null) {
            throw new NoMoreIcecreamException("Out of Magni");
        } else
            return yourMagnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) {
        int stockMagnum = stock.getMagni();

        if (stockMagnum >= 1) {
            Magnum yourMagnum = new Magnum(type);
            profit += priceList.getMagnumPrice(type);
            stock.setMagni(stockMagnum - 1);
            return yourMagnum;
        } else
            return null;
    }

    @Override
    public double getProfit() {
        return profit;
    }

    @Override
    public String toString() {
        return String.format("Welcome to my ice cream kart. Prices are %.2f " +
                                     "for a normal Magnum, %.2f for 1 ball " +
                                     "and %.2f for an IceRocket.",
                             priceList.getMagnumPrice(
                                     Magnum.MagnumType.BLACKCHOCOLATE),
                             priceList.getBallPrice(),
                             priceList.getRocketPrice());
    }
}
