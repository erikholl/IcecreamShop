package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    // variables
    private MagnumType type;

    // constructors
    public Magnum() {
        this(MagnumType.ALPINENUTS);
    }

    public Magnum(MagnumType type) {
        this.type = type;
    }

    // methods
    public MagnumType getType() {
        return type;
    }

    @Override
    public void eat() {
        System.out.println("How delicious... I'm eating a " + type + " Magnum" +
                                   ".");
    }

    // nested enum
    public enum MagnumType {
        ALPINENUTS(1.5),
        BLACKCHOCOLATE(1),
        MILKCHOCOLATE(1.25),
        ROMANTICSSTRAWBERRIES(2),
        WHITECHOCOLATE(1);

        private double value;

        // constructor
        MagnumType(double value) {
            setValue(value);
        }

        // setter
        public void setValue(double value) {
            this.value = value;
        }

        // getter
        public double getValue() {
            return value;
        }
    }

}
