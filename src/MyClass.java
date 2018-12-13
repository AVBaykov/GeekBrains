import java.time.Year;

public class MyClass {
    public static void main(String[] args) {

        /**
         * второй пункт ДЗ
         */
        boolean a = true;
        char b = 'b';
        byte c = 8;
        short d = 10;
        int e = 100;
        long f = 1000L;
        float g = 1.0F;
        double h = 20.5;
        String string = "строка";
    }

    /**
     * третий пункт ДЗ
     */
    static int someFunction(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    /**
     * четвертый пункт ДЗ
     */
    static boolean isSumBetweenTenAndTwenty(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    /**
     * пятый пункт ДЗ
     */
    static void positiveOrNegative(int a) {
        System.out.println(a >= 0 ? "positive" : "negative");
    }

    /**
     * шестой пункт ДЗ
     */
    static boolean isNegative(int a) {
        return a < 0;
    }

    /**
     * седьмой пункт ДЗ
     */
    static void pringName(String name) {
        System.out.printf("Привет, %s!", name);
    }

    /**
     * восьмой пункт ДЗ
     */
    static void leapYear(int year) {
        System.out.println(Year.isLeap(year) ? "високосный" : "не високосный");
    }
}
