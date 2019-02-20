import org.junit.jupiter.api.Test;

import static TestUtils.ArrayTestData.*;
import static org.junit.jupiter.api.Assertions.*;

class ArraySearchTest {

    @Test
    void printArray() throws Exception {
        int[] actual = ArraySearch.printArrayAfterLastFour(ARRAY_1);

        assertArrayEquals(EXPECTED_1, actual);
    }

    @Test
    void printArrayWithNull() throws Exception {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> ArraySearch.printArrayAfterLastFour(null));
        assertTrue(thrown.getMessage().contains("Массив не должен быть пустым"));
    }

    @Test
    void printArrayWithoutFour() throws Exception {
        assertThrows(ArrayStoreException.class, () -> ArraySearch.printArrayAfterLastFour(ARRAY_2));
    }

    @Test
    void containsOneOrFour() throws Exception {
        assertTrue(ArraySearch.containsOneOrFour(ARRAY_1));
    }

    @Test
    void containsOneOrFourWithNull() throws Exception {
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> ArraySearch.containsOneOrFour(null));
        assertTrue(thrown.getMessage().contains("Массив не должен быть пустым"));
    }

    @Test
    void notContainsOneOrFour() throws Exception {
        assertFalse(ArraySearch.containsOneOrFour(ARRAY_2));
    }

}