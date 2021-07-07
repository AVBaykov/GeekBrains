public class MainClass {
    private static int size = 10_000_000;

    public static void main(String[] args) throws InterruptedException {
        arrayCalculation();
        arraySplitCalculation();
    }

    public static void arrayCalculation() {
        float[] array = initArrayByOne(size);

        long a = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println(System.currentTimeMillis() - a + " ms");
    }

    public static void arraySplitCalculation() throws InterruptedException {
        float[] array = initArrayByOne(size);
        int h = size / 2;

        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(array, 0, a1, 0, h);
        System.arraycopy(array, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] =  (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] =  (float)(a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(a1, 0, array, 0, h);
        System.arraycopy(a2, 0, array, h, h);

        System.out.println(System.currentTimeMillis() - a + " ms");
    }

    /**
     * @param size - set array size
     * @return - array of all 1
     */
    private static float[] initArrayByOne(int size) {
        float[] array = new float[size];
        for (int i = 0; i < size; i++) {
            array[i] = 1;
        }
        return array;
    }
}
