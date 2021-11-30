package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    // variables
    private final MagnumType TYPE; // final as MagnumType = enum (fixed, below)

    // constructors
    public Magnum() {
        this(MagnumType.BLACKCHOCOLATE);
    }

    public Magnum(MagnumType type) {
        this.TYPE = type;
    }

    // methods
    public MagnumType getTYPE() {
        return TYPE;
    }

    @Override
    public void eat() {
        System.out.println("Eating a " + getTYPE() + ".");
    }

    // nested enum MagnumType
    public enum MagnumType {
        ALPINENUTS(1.5) {
            public String toString() {
                return "Magnum alpine nuts";
            }
        },
        BLACKCHOCOLATE(1) {
            public String toString() {
                return "Magnum black chocolate";
            }
        },
        MILKCHOCOLATE(1.25) {
            public String toString() {
                return "Magnum milk chocolate";
            }
        },
        ROMANTICSTRAWBERRIES(2) {
            public String toString() {
                return "Magnum romantic strawberry";
            }
        },
        WHITECHOCOLATE(1.25) {
            public String toString() {
                return "Magnum white chocolate";
            }
        };

        private double standardPriceMultiplier;

        // constructor enum
        MagnumType(double multiplier) {
            setStandardPriceMultiplier(multiplier);
        }

        // setter enum
        public void setStandardPriceMultiplier(double standardPriceMultiplier) {
            this.standardPriceMultiplier = standardPriceMultiplier;
        }

        // getter enum
        public double getStandardPriceMultiplier() {
            return standardPriceMultiplier;
        }
    }

}
