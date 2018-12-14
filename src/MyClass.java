import java.util.Arrays;

public class MyClass {
    public static void main(String[] args) {

        /**
         * первый пункт ДЗ
         */
        int[] fstArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < fstArray.length; i++) {
            if (fstArray[i] == 1) {
                fstArray[i] = 0;
            } else {
                fstArray[i] = 1;
            }
        }

        /**
         * второй пункт ДЗ
         */
        int[] sndArray = new int[8];

        for (int i = 1; i < sndArray.length; i++) {
            sndArray[i] = sndArray[i - 1] + 3;
        }

        /**
         * третий пункт ДЗ
         */
        int[] trdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < trdArray.length; i++) {
            if (trdArray[i] < 6) {
                trdArray[i] *= 2;
            }
        }

        /**
         * четвертый пункт ДЗ
         */
        int[][] fourthArray = new int[10][10];

        for (int i = 0; i < fourthArray.length; i++) {
            fourthArray[i][i] = 1;
            fourthArray[i][fourthArray.length - i - 1] = 1;
        }

        System.out.println("Проверка четвертого пункта");
        for (int i = 0; i < fourthArray.length; i++) {
            for (int j = 0; j < fourthArray[i].length; j++) {
                System.out.print(fourthArray[i][j] + "\t");
            }
            System.out.println();
        }

        /**
         * пятый пункт ДЗ
         */
        System.out.println();
        System.out.println("Проверка пятого пункта");
        int min, max;
        int[] fifthArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        Arrays.sort(fifthArray);
        min = fifthArray[0];
        max = fifthArray[fifthArray.length - 1];
        System.out.println(min + " " + max);


        /**
         * проверка 7ого пункта ДЗ
         */
        System.out.println();
        System.out.println("Проверка седьмого пункта");
        int[] test = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(shift(test, -2)));
    }

    /**
     * шестой пункт ДЗ
     */
    static boolean checkBalance(int[] array) {
        if (array != null) {
            int sum = 0;
            int partial = 0;

            for (int i : array) {
                sum += i;
            }

            for (int i : array) {
                partial += i;
                sum -= i;
                if (partial == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * седьмой пункт ДЗ
     */
    static int[] shift(int[] array, int offset) {
        if (offset == 0) {
            return array;
        }
        offset = offset % array.length;
        return offset > 0 ? shiftRight(array, offset) : shiftLeft(array, offset);
    }

    private static int[] shiftRight(int[] array, int offset) {
        for (int i = 0; i < offset; i++) {
            int temp = array[array.length - 1];
            System.arraycopy(array, 0, array, 1, array.length - 1);
            array[0] = temp;
        }
        return array;
    }

    private static int[] shiftLeft(int[] array, int offset) {
        for (int i = 0; i > offset; i--) {
            int temp = array[0];
            System.arraycopy(array, 1, array, 0, array.length - 1);
            array[array.length - 1] = temp;
        }
        return array;
    }

}
