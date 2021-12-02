package be.intecbrussel.sellers;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;

public class IceCreamSalon implements IceCreamSeller {

    private PriceList priceList;
    private double totalProfit;

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
        totalProfit += flavors.length * priceList.getBallPrice();
        System.out.println(yourCone + " ordered!");
        return yourCone;
    }

    @Override
    public IceRocket orderIceRocket() {
        IceRocket yourRocket = new IceRocket();
        totalProfit += priceList.getRocketPrice();
        System.out.println(yourRocket + " ordered!");
        return yourRocket;
    }

    @Override
    public Magnum orderMagnum(Magnum.MagnumType type) {
        Magnum yourMagnum = new Magnum(type);
        totalProfit += priceList.getMagnumPrice(type);
        System.out.println(yourMagnum + " ordered!");
        return yourMagnum;
    }

    @Override
    public double getProfit() {
        return totalProfit;
    }

    @Override
    public String toString() {
        return String.format("\nHello. In this ice cream salon prices are: %" +
                                     ".2f" +
                                     " for an IceRocket, %.2f for a normal " +
                                     "Magnum and %.2f for 1 ball if ice cream" +
                                     " (more balls is however strongly " +
                                     "recommended).\n",
                             priceList.getRocketPrice(),
                             priceList.getMagnumPrice(
                                     Magnum.MagnumType.BLACKCHOCOLATE),
                             priceList.getBallPrice());
    }
}
