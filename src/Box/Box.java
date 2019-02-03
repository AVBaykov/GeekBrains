package Box;

import Fruit.AbstractFruit;

import java.util.ArrayList;
import java.util.List;

public class Box<F extends AbstractFruit> {

    private List<F> fruits = new ArrayList<>();

    public void putFruit(F fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double weight = 0.0;

        for (AbstractFruit fruit : fruits) {
            weight += fruit.getWeight();
        }

        return weight;
    }

    public void moveFruits(Box<F> box) {
        box.setFruits(fruits);
        fruits.clear();
    }

    public void setFruits(List<F> fruits) {
        this.fruits = fruits;
    }

    public boolean compare(Box box) {
        return this.getWeight() - box.getWeight() == 0.0;
    }
}
