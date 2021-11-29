package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {

    // variables
    private PriceList priceList;
    private double totalProfit;

    // constructors
    public IceCreamSalon() {
        this(new PriceList());
    }

    public IceCreamSalon(PriceList priceList) {
        this.priceList = priceList;
    }

    // methods
    @Override
    public Cone orderCone(Cone.Flavor[] flavors) {
        Cone yourCone = new Cone(flavors);
        totalProfit =
                totalProfit + (flavors.length * (0.4 * priceList.getBallPrice()));
                // 0.4, 40% of price is profit in Salon Venezia
        return yourCone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket yourRocket = new IceRocket();
        totalProfit = totalProfit + (0.2 * priceList.getRocketPrice());
        return yourRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum yourMagnum = new Magnum(type);
        totalProfit = totalProfit + (0.3 * priceList.getMagnumPrice(type));
        return yourMagnum;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    // TODO: proper override toString
    @Override
    public String toString() {
        return "IceCreamShop";
    }
}
