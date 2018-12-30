package util;

import exceptions.MyArrayDataException;
import exceptions.MySizeArrayException;

public class Util {

    public static void arraySum(String[][] array) throws MySizeArrayException, MyArrayDataException {
        if (!checkSize(array)) {
            throw new MySizeArrayException("Неверная размерность! Массив должен быть 4 на 4");
        }

        int result = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    System.out.println(result);
                    throw new MyArrayDataException("Не удалось преобразовать данные в ячейке [%d][%d]", i, j);
                }
            }
        }
        System.out.println(result);
    }

    private static boolean checkSize(String[][] array) {
        return array.length == 4 && array[0].length == 4;
    }
}
