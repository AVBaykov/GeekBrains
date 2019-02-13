import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class TaskTwo {

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("testFiles\\testFile.txt"))) {
            byte[] bytes = new byte[50];
            fis.read(bytes);
            System.out.println(Arrays.toString(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
