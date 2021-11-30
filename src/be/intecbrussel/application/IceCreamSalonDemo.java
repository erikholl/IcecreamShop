package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

import static be.intecbrussel.eatables.Cone.Flavor.*;
import static be.intecbrussel.eatables.Magnum.MagnumType.*;

public class IceCreamSalonDemo {

    public static void main(String[] args) {

        PriceList priceListVenezia = new PriceList(0.75, 1.5, 2);
        IceCreamSeller salonVenezia = new IceCreamSalon(priceListVenezia);

        // order ice cream
        IceRocket r1 = salonVenezia.orderIceRocket();
        IceRocket r2 = salonVenezia.orderIceRocket();
        Magnum m1 = salonVenezia.orderMagnum(BLACKCHOCOLATE);
        Magnum m2 = salonVenezia.orderMagnum(WHITECHOCOLATE);
        Magnum m3 = salonVenezia.orderMagnum(ALPINENUTS);
        Cone c1 = salonVenezia.orderCone(new Cone.Flavor[]{CHOCOLATE,
                VANILLA, STRAWBERRY});
        Cone c2 = salonVenezia.orderCone(new Cone.Flavor[]{LEMON, STRAWBERRY,
                STRACIATELLA, VANILLA, CHOCOLATE, PISTACHE, MOKKA});
        Cone c3 = salonVenezia.orderCone(new Cone.Flavor[]{BANANA});

        // put ice in array and apply eat
        Eatable[] eatables = {r1, r2, m1, m2, m3, c1, c2, c3};
        for (Eatable icecream : eatables) {
            icecream.eat();
        }

        // check profit
        System.out.println(salonVenezia);
        System.out.println("Total profit of salon Venezia: " + salonVenezia.getProfit());

    }

}
