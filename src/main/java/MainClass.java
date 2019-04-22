import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        Array<Integer> arrayForBubble = new ArrayImpl<>();
        Random rand = new Random();

        for (int i = 0; i < 1_000_000; i++) {
            arrayForBubble.add(rand.nextInt(1_000_000));
        }

        Array<Integer> arrayForSelect = arrayForBubble.getCopy();
        Array<Integer> arrayForInsert = arrayForBubble.getCopy();

        long start = System.currentTimeMillis();
        arrayForBubble.bubbleSort();
        System.out.println(System.currentTimeMillis() - start + "ms");

        start = System.currentTimeMillis();
        arrayForSelect.sortSelect();
        System.out.println(System.currentTimeMillis() - start + "ms");

        start = System.currentTimeMillis();
        arrayForInsert.sortInsert();
        System.out.println(System.currentTimeMillis() - start + "ms");

    }
}
