import java.util.concurrent.ArrayBlockingQueue;

public class Tunnel extends Stage {

    private static final ArrayBlockingQueue<Car> CAPACITY = new ArrayBlockingQueue<>(MainClass.CARS_COUNT / 2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                CAPACITY.put(c);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                CAPACITY.remove(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}