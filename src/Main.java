import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] array = {"Кошка", "Собака", "геолог", "геолог", "ваниль", "гектар",
                "Кошка", "котенок", "слоненок", "копать", "ваниль", "гектар",
                "гектар", "собака", "собака", "выпь", "сыпь", "кошка"};

        Map<String, Integer> words = new HashMap<>();

        Arrays.stream(array).forEach(word -> words.merge(word.toLowerCase(), 1, (oldValue, inc) -> oldValue + inc));

        words.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
