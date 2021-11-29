package be.intecbrussel.eatables;

public class IceRocket implements Eatable {

    //constructor
    public IceRocket() {
    }

    // methods
    @Override
    public void eat() {
        System.out.println("Ahh this is good with all this heat. I'm eating " +
                                   "an Icerocket.");
    }
}
