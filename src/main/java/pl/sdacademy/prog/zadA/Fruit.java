package pl.sdacademy.prog.zadA;

public interface Fruit {
    Double getWeight();
    String getColour();
    default boolean isRooten() {
        return false;
    }
}
