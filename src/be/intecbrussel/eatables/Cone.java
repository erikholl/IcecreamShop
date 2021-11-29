package be.intecbrussel.eatables;

import java.util.Arrays;

// TODO: default for empty constrctor
public class Cone implements Eatable {

    // variables
    private Flavor[] balls = new Flavor[0];
//    private static final String DEFAULT = "BANANA";

    // constructors
    public Cone() {
//        balls = new Flavor[DEFAULT];
    }

    public Cone(Flavor[] balls) {
        this.balls = balls;
    }

    @Override
    public void eat() {
        if (balls.length == 0) {
            System.out.println("Yummie! Enjoying a cone without flavors! " +
                                       "(Weeirrrd :))");
        } else if (balls.length == 1) {
            System.out.println("Yummie! Enjoying a cone with flavor " + Arrays.toString(
                    balls) + ".");
        } else {
            System.out.println("Yummie! Enjoying a cone with " + balls.length + " flavors: ");
            for (Flavor ball : balls) {
                System.out.println(ball);
            }
        }
    }

    public enum Flavor {
        BANANA,
        CHOCOLATE,
        LEMON,
        MOKKA,
        PISTACHE,
        STRACIATELLA,
        STRAWBERRY,
        VANILLA;
    }

}
