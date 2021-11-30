package be.intecbrussel.eatables;

import java.util.Arrays;

// TODO: HATE THE BRACKETS OUTPUT WHEN PRINTING..
public class Cone implements Eatable {
    // variables
    private final Flavor[] BALLS; // final as Flavor = enum (fixed, below)

    // constructors
    public Cone() {
        this(new Flavor[0]);
    }

    public Cone(Flavor[] balls) {
        this.BALLS = balls;
    }

    @Override
    public void eat() {
        if (BALLS.length == 0) {
            System.out.println("Eating a cone without balls.");
        } else if (BALLS.length == 1) {
            System.out.println("Eating a cone with 1 ball of " + Arrays.toString(
                    this.BALLS) +
                               ".");
        } else {
            System.out.println("Eating a cone with " + BALLS.length + " balls: " + Arrays.toString(
                    this.BALLS) + ".");
//            for (Flavor ball : balls) {
//                System.out.println(ball);
//            }
        }
    }

//    private String removeBrackets() {
//        String balls = Arrays.toString(BALLS);
//        balls = balls.substring(1, balls.length() - 1);
//        return balls;
//    }

    // nested enum Flavor
    public enum Flavor {
        BANANA {
            public String toString() {
                return "banana";
            }
        },
        CHOCOLATE {
            public String toString() {
                return "chocolate";
            }
        },
        LEMON {
            public String toString() {
                return "lemon";
            }
        },
        MOKKA {
            public String toString() {
                return "mokka";
            }
        },
        PISTACHE {
            public String toString() {
                return "pistache";
            }
        },
        STRACIATELLA {
            public String toString() {
                return "straciatella";
            }
        },
        STRAWBERRY {
            public String toString() {
                return "strawberry";
            }
        },
        VANILLA {
            public String toString() {
                return "vanilla";
            }
        }
    }

}
