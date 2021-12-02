package be.intecbrussel.application;

import be.intecbrussel.eatables.*;
import be.intecbrussel.sellers.*;

import java.util.ArrayList;
import java.util.Objects;

import static be.intecbrussel.eatables.Cone.Flavor.*;
import static be.intecbrussel.eatables.Magnum.MagnumType.*;

public class IceCreamCarDemo {

    public static void main(String[] args) {

        // create your IceCream kart with price list and stock
        PriceList priceListMariosIceKart = new PriceList(0.9, 1.5, 2.5);
        Stock stockMariosIceKart = new Stock(2, 3, 6, 2);
        IceCreamSeller mariosIceKart = new IceCreamCar(priceListMariosIceKart,
                                                       stockMariosIceKart);

        // print your newly created kart
        System.out.println(mariosIceKart);

        // order ice cream, add orders to arraylist (allows flexible length)
        ArrayList<Eatable> listWithOrders = new ArrayList<>();

        listWithOrders.add(mariosIceKart.orderIceRocket());
        listWithOrders.add(mariosIceKart.orderMagnum(WHITECHOCOLATE));
        listWithOrders.add(mariosIceKart.orderCone(new Cone.Flavor[]{BANANA,
                LEMON, PISTACHE}));
        listWithOrders.add(mariosIceKart.orderIceRocket());
        listWithOrders.add(mariosIceKart.orderCone(new Cone.Flavor[]{BANANA,
                LEMON, PISTACHE, VANILLA, CHOCOLATE, STRAWBERRY}));
        listWithOrders.add(mariosIceKart.orderMagnum(ALPINENUTS));
        listWithOrders.add(mariosIceKart.orderIceRocket());

        // remove 'null'-objects from arraylist with orders: nulls are returned
        // by exception handling when stock is too low (see NoMoreIceCream
        // exception handling in prepare/order methods in IceCreamCar-class
        listWithOrders.removeIf(Objects::isNull);

        // convert arraylist with orders >>> array with Eatables
        Eatable[] eatables = listWithOrders.toArray(new Eatable[0]);

        // run through array Eatables and apply 'eat' for each Eatable
        for (Eatable icecream : eatables) {
            icecream.eat();
        }

        // print profit
        System.out.printf("Total profit of Mario's ice kart is: %.2f",
                           mariosIceKart.getProfit());
    }

}
