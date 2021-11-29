package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamCar implements IceCreamSeller {

    // variables
    private PriceList priceList = new PriceList();
    private Stock stock = new Stock();
    private double profit = 0;

    // constructor
    public IceCreamCar(PriceList priceList, Stock stock) {
        this.priceList = priceList;
        this.stock = stock;
    }

    // TODO: extend cone methods to make diff between cones / balls shortage
    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone yourCone = prepareCone(flavors);

        if (yourCone == null) {
            throw new NoMoreIcecreamException("Out of Cones");
        } else return yourCone;
    }

    private Cone prepareCone(Cone.Flavor[] flavors) {
        int stockCones = stock.getCones();
        int stockBalls = stock.getBalls();

        if (stockCones >= 1 && stockBalls >= flavors.length) {
            Cone yourCone = new Cone(flavors);
            profit =
                    profit + (flavors.length * (0.5 * priceList.getBallPrice()));
            stock.setCones(stockCones - 1);
            stock.setBalls(stockBalls - flavors.length);
            return yourCone;
        } else return null;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket yourRocket = prepareRocket();

        if (yourRocket == null) {
            throw new NoMoreIcecreamException("Out of IceRockets");
        } else return yourRocket;
    }

    private IceRocket prepareRocket() {
        int stockIceRockets = stock.getIceRockets();

        if (stockIceRockets >= 1) {
            IceRocket yourRocket = new IceRocket();
            profit = profit + (0.4 * priceList.getRocketPrice());
            stock.setIceRockets(stockIceRockets - 1);
            return yourRocket;
        } else return null;
    }

    // TODO?? relate stock to magnum type??
    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum yourMagnum = prepareMagnum(type);

        if (yourMagnum == null) {
            throw new NoMoreIcecreamException("Out of Magni");
        } else return yourMagnum;
    }

    private Magnum prepareMagnum(Magnum.MagnumType type) {
        int stockMagnum = stock.getMagni();

        if (stockMagnum >= 1) {
            Magnum yourMagnum = new Magnum(type);
            profit = profit + (0.5 * priceList.getMagnumPrice(type));
            stock.setMagni(stockMagnum - 1);
            return yourMagnum;
        } else return null;
    }

    @Override
    public double getProfit() {
        return profit;
    }

    // TODO: proper override toString
    @Override
    public String toString() {
        return "IceCreamCar";
    }
}
