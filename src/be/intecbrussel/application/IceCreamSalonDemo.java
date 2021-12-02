package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.IceCreamSalon;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

import java.util.ArrayList;

import static be.intecbrussel.eatables.Cone.Flavor.*;
import static be.intecbrussel.eatables.Magnum.MagnumType.*;

public class IceCreamSalonDemo {

    public static void main(String[] args) {

        // create your IceCream Salon with price list
        PriceList priceListVenezia = new PriceList(0.75, 1.5, 2);
        IceCreamSeller salonVenezia = new IceCreamSalon(priceListVenezia);

        // print your newly created salon
        System.out.println(salonVenezia);

        // order ice cream, add orders to arraylist (allows flexible length)
        ArrayList<Eatable> listWithOrders = new ArrayList<>();

        listWithOrders.add(salonVenezia.orderMagnum(ALPINENUTS));
        listWithOrders.add(salonVenezia.orderCone(new Cone.Flavor[]{STRAWBERRY, LEMON}));
        listWithOrders.add(salonVenezia.orderCone(new Cone.Flavor[]{PISTACHE,
                STRACIATELLA}));
        listWithOrders.add(salonVenezia.orderIceRocket());
        listWithOrders.add(salonVenezia.orderMagnum(ROMANTICSTRAWBERRIES));
        listWithOrders.add(salonVenezia.orderCone(new Cone.Flavor[]{BANANA,
                VANILLA}));
        listWithOrders.add(salonVenezia.orderIceRocket());

        // convert arraylist with orders >>> array with Eatables
        Eatable[] eatables = listWithOrders.toArray(new Eatable[0]);

        // run through array Eatables and apply 'eat' for each Eatable
        for (Eatable iceCream : eatables) {
            iceCream.eat();
        }

        // print profit
        System.out.printf("Total profit of salon Venezia is: %.2f", salonVenezia.getProfit());
    }

}
