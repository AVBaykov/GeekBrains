import java.util.Map;
import java.util.TreeMap;

public class Phonebook {

    private Map<String, String> map = new TreeMap<>();


    public void add(String sName, String phone) {
        map.merge(sName, phone, (oldValue, newValue) -> String.join(" ", oldValue, newValue));
    }
}
