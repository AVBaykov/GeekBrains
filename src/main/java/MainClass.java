import java.util.HashMap;
import java.util.Map;

public class MainClass {
    public static void main(String[] args) {
        int[] array = {1,2,3,2,3,1,1,1,1,3};
        System.out.println(countTrees(array));
    }

    public static Map<Integer, Integer> countTrees(int[] forest) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int tree : forest) {
            map.merge(tree, 1, (oldValue, one) -> oldValue + one);
        }
        return map;
    }
}
