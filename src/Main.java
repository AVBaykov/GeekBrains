import exceptions.MyArrayDataException;
import exceptions.MySizeArrayException;
import util.Util;

public class Main {

    public static void main(String[] args) {
        String[][] array = {{"1", "2", "3", "4"},
                            {"5", "6", "Бусы", "7"},
                            {"8", "9", "10", "11"},
                            {"12", "13", "14", "15"}};

        try {
            Util.arraySum(array);
        } catch (MySizeArrayException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }
}
