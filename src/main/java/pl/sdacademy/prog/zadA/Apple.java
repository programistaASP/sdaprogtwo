package pl.sdacademy.prog.zadA;

import java.util.Random;

public class Apple implements Fruit {
    private  String color;
    private  Double weight;
    private boolean rotten;

    public Apple(final String color, final Double weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public Double getWeight() {
        return weight;
    }

    @Override
    public String getColour() {
        return color;
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
