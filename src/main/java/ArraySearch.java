import java.util.Arrays;
import java.util.Objects;

public class ArraySearch {

    public static int[] printArrayAfterLastFour(int[] array) {
        Objects.requireNonNull(array, "Массив не должен быть пустым");
        int last = array.length - 1;
        if (array[last] == 4) {
            return new int[0];
        }
        for (int i = last; i >= 0 ; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new ArrayStoreException("Массив должен содержать хотя бы одну четверку");
    }

    public static boolean containsOneOrFour(int[] array) {
        Objects.requireNonNull(array, "Массив не должен быть пустым");
        for (int a : array) {
            if (a == 1 || a == 4) {
                return true;
            }
        }
        return false;
    }
}
