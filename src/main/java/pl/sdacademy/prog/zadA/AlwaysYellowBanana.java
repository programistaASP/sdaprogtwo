package pl.sdacademy.prog.zadA;

import java.util.Random;

public class AlwaysYellowBanana implements Fruit {
    private static final String YELLOW_COLOR = "Yellow";
    private Double weight;
    private boolean rotten;

    public AlwaysYellowBanana(final Double weight) {
        this.weight = weight;
    }

    @Override
    public Double getWeight() {
        return weight;
    }

    @Override
    final public String getColour() {
        return YELLOW_COLOR;
    }

    @Override
    public boolean isRooten() {
        if (rotten) {
            return rotten;
        }
        rotten = new Random().nextBoolean();
        return rotten;
    }
}
