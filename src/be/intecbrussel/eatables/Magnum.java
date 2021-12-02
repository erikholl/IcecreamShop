package be.intecbrussel.eatables;

public class Magnum implements Eatable {

    private final MagnumType TYPE; // final as MagnumType = enum (fixed, below)

    public Magnum() { // default Magnum constructor
        this(MagnumType.BLACKCHOCOLATE);
    }

    public Magnum(MagnumType type) {
        this.TYPE = type;
    }

    public MagnumType getTYPE() {
        return TYPE;
    }

    @Override
    public void eat() {
        System.out.println("Eating a " + this + ".");
    }

    @Override
    public String toString() {
        return String.valueOf(getTYPE());
    }

    // nested enum MagnumType - incl. override toString per type
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

        // setter price multiplier
        public void setStandardPriceMultiplier(double standardPriceMultiplier) {
            this.standardPriceMultiplier = standardPriceMultiplier;
        }

        // getter price multiplier
        public double getStandardPriceMultiplier() {
            return standardPriceMultiplier;
        }
    }

}
