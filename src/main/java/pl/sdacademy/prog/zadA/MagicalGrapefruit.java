package pl.sdacademy.prog.zadA;

public class MagicalGrapefruit implements Fruit {
    private String color;
    private Double weight;

    public MagicalGrapefruit(final String color, final Double weight) {
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
}
