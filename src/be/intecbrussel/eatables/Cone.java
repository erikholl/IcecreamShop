package be.intecbrussel.eatables;

public class Cone implements Eatable {

    private final Flavor[] BALLS; // final as Flavor = enum (fixed, below)

    public Cone() {  // default Cone constructor - no flavor, just a cone
        this(new Flavor[0]);
    }

    public Cone(Flavor[] balls) {
        this.BALLS = balls;
    }

    @Override
    public void eat() {
        System.out.println("Eating a " + this + ".");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cone with ");

        if (BALLS.length == 0) {
            sb.append("no balls");
        } else {
            for (int i = 0; i < BALLS.length; i++) {
                if (i == BALLS.length - 1) { // subtract 1 of length  = last index
                    sb.append(BALLS[i]);
                } else {
                    sb.append(BALLS[i]).append(", ");
                }
            }
        }
        return sb.toString();
    }

    // nested enum Flavor - incl. override toString per Flavor
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
