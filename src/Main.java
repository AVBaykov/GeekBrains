public class Main {
    public static void main(String[] args) {
        Bowl bowl = new Bowl(30);
        Cat[] catsArray = new Cat[10];

        for (int i = 0; i < 10; i++) {
            catsArray[i] = new Cat("Кот" + i);
        }

        for (Cat cat : catsArray) {
            cat.eat(bowl);
            if (bowl.getCurrentFood() == 0) {
                bowl.refill();
            }
        }

        for (Cat cat : catsArray) {
            cat.checkBellyful();
        }
    }
}
