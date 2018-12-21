import java.util.Random;

public class Cat extends Animal {

    private String name;
    private int appetite;
    private boolean bellyful = false;


    public Cat(String name) {
        super(200, 2, -1);
        this.name = name;
        this.appetite = new Random().nextInt(15);
    }

    public void eat(Bowl bowl) {
        if (checkFood(bowl.getCurrentFood())) {
            bowl.reduceFood(appetite);
            bellyful = true;
        }
    }

    private boolean checkFood(int food) {
        return food >= appetite;
    }


    public void checkBellyful() {
        if (bellyful) {
            System.out.println(name + ": сыт");
        } else {
            System.out.println(name + ": голоден");
        }
    }

}
