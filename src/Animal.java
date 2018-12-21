import java.util.Random;

public abstract class Animal {
    private int runLimit;
    private double jumpLimit;
    private int swimLimit;

    Animal(int runLimit, double jumpLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.swimLimit = swimLimit;
    }

    /**
     * 6-ой пункт ДЗ
     */
    void run(int runLimit) {
        System.out.printf("run: %s\n", runLimit > 0 && runLimit <= this.runLimit);
    }

    void jump(double jumpLimit) {
        System.out.printf("jump: %s\n", jumpLimit > 0 && jumpLimit <= this.jumpLimit);
    }

     void swim(int swimLimit) {
         System.out.printf("swim: %s\n", swimLimit > 0 && swimLimit <= this.swimLimit);
    }

    /**
     * Вспомогательные методы для разброса ограничений животного (9-ый пункт ДЗ)
     */
    static int intSpreading(int min, int max) {
        Random random = new Random();
        return random.nextBoolean() ? random.nextInt(max) : -random.nextInt(min);
    }

    static double doubleSpreading(double min, double max) {
        Random random = new Random();
        return random.nextBoolean() ? (Math.random() * max) : -(Math.random() * min);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                ", swimLimit=" + swimLimit +
                '}';
    }
}
