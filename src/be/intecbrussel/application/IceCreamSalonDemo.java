package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.IceRocket;
import be.intecbrussel.eatables.Magnum;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

import static be.intecbrussel.eatables.Cone.Flavor.CHOCOLATE;
import static be.intecbrussel.eatables.Cone.Flavor.VANILLA;

// TODO: Eatable array

public class IceCreamSalonDemo {

    public static void main(String[] args) {

        // create instances of
        PriceList priceListVenezia = new PriceList(0.75, 1.5, 2);
        IceCreamSalon salonVenezia = new IceCreamSalon(priceListVenezia); //
        // use IceCreamSeller instead?

        // order ice cream
        IceRocket rocket1 = salonVenezia.orderIceRocket();
        IceRocket rocket2 = salonVenezia.orderIceRocket();
        Magnum magnum1 =
                salonVenezia.orderMagnum(Magnum.MagnumType.BLACKCHOCOLATE);
        Magnum magnum2 =
                salonVenezia.orderMagnum(Magnum.MagnumType.WHITECHOCOLATE);
        Magnum magnum3 = salonVenezia.orderMagnum(Magnum.MagnumType.ALPINENUTS);
        Cone cone1 = salonVenezia.orderCone(new Cone.Flavor[]{VANILLA, CHOCOLATE});

        // apply 'eat' method
        rocket1.eat();
        rocket2.eat();
        magnum1.eat();
        magnum2.eat();
        magnum3.eat();
        cone1.eat();

        // check profit
        System.out.println(salonVenezia.getProfit());

    }
}
