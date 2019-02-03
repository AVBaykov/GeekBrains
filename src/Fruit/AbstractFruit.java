package Fruit;

public abstract class AbstractFruit {

    private final double weight;

    public AbstractFruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }
}
