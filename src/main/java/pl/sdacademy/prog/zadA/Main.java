package pl.sdacademy.prog.zadA;

public class Main {
    public static void main(String[] args) {
        final Fruit apple = new Apple("Red", 2.3);
        final Fruit banana = new AlwaysYellowBanana(2.5);
        final Fruit grapefruit = new MagicalGrapefruit("Grejfrutowy", 4.5);

        final FruitBox<Fruit> fruitBox = new FruitBox<>();
        final FruitBox<Apple> appleFruitBox = new FruitBox<>();
        final FruitBox<AlwaysYellowBanana> bananaBo = new FruitBox<>();

        fruitBox.addFruit(apple);
        fruitBox.addFruit(banana);
        fruitBox.addFruit(grapefruit);
        fruitBox.removeRotten();
    }
}
