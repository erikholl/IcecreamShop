package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamCar;
//import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

import static be.intecbrussel.eatables.Cone.Flavor.CHOCOLATE;
import static be.intecbrussel.eatables.Cone.Flavor.VANILLA;

// TODO: Eatable array
// TODO: proper implementation of exception
// TODO: can the order methods be simplified when calling them?

public class IceCreamCarDemo {

    public static void main(String[] args) {
        
        // create instances of
        PriceList priceListMariosIceKart = new PriceList(0.9, 2, 2.5);
        Stock stockMariosIceKart = new Stock(1, 3, 5, 2);
        IceCreamCar mariosIceKart = new IceCreamCar(priceListMariosIceKart,
                                                 stockMariosIceKart); // use
        // IceCreamSeller instead?

        // order ice cream
        IceRocket rocket1 = mariosIceKart.orderIceRocket();
        IceRocket rocket2 = mariosIceKart.orderIceRocket();
        Magnum magnum1 =
                mariosIceKart.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        Magnum magnum2 =
                mariosIceKart.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        Magnum magnum3 = mariosIceKart.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        Cone cone1 = mariosIceKart.orderCone(new Cone.Flavor[]{VANILLA, CHOCOLATE});
        
        // apply 'eat' method 
        rocket1.eat();
        rocket2.eat();
        magnum1.eat();
        magnum2.eat();
        magnum3.eat();
        cone1.eat();
        
        // check profit
        System.out.println(mariosIceKart.getProfit());
    }
}
