package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;
import be.intecbrussel.sellers.Stock;

import static be.intecbrussel.eatables.Cone.Flavor.*;
import static be.intecbrussel.eatables.Magnum.MagnumType.*;

// TODO: proper implementation of exception

public class IceCreamCarDemo {

    public static void main(String[] args) {
        
        // create instances of
        PriceList priceListMariosIceKart = new PriceList(0.9, 2, 2.5);
        Stock stockMariosIceKart = new Stock(3, 4, 5, 1);
        IceCreamSeller mariosIceKart = new IceCreamCar(priceListMariosIceKart,
                                                 stockMariosIceKart);

        // order ice cream
        IceRocket r1 = mariosIceKart.orderIceRocket();
        IceRocket r2 = mariosIceKart.orderIceRocket();
        Magnum m1 =
                mariosIceKart.orderMagnum(BLACKCHOCOLATE);
        Magnum m2 =
                mariosIceKart.orderMagnum(WHITECHOCOLATE);
        Magnum m3 = mariosIceKart.orderMagnum(ALPINENUTS);
        Cone c1 = mariosIceKart.orderCone(new Cone.Flavor[]{VANILLA, CHOCOLATE});
        Cone c2 = mariosIceKart.orderCone(new Cone.Flavor[0]);
        
        // apply 'eat' method 
        Eatable[] eatables = {r1, r2, m1, m2, m3, c1, c2};
        for (Eatable icecream : eatables) {
            icecream.eat();
        }
        
        // check profit
        System.out.println(mariosIceKart);
        System.out.println(mariosIceKart.getProfit());
    }
}
