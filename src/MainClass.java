import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainClass {
    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(array));
        switchArrayElements(array, 1, 4);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Первый пункт ДЗю
     * @param array - массив, в котором нужно поменять элементы местами
     * @param fstIndex - индекс первого элемента
     * @param sndIndex - индекс второго элемента
     */
    public static <E> void switchArrayElements(E[] array, int fstIndex, int sndIndex) {
        Objects.requireNonNull(array, "Array can not be null");
        if (checkBounds(array.length, fstIndex) && checkBounds(array.length, sndIndex)) {
            E temp = array[fstIndex];
            array[fstIndex] = array[sndIndex];
            array[sndIndex] = temp;
        }
    }

    /**
     * Return ArrayList from Object[] array;
     * @param array array of Objects
     * @param <T> concrete type of Object
     *           Пункт 2 домашнего задания
     */
    public <T> List<T> toArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    private static boolean checkBounds(int arraySize, int index) {
        return index >= 0 && index <= arraySize;
    }
}
