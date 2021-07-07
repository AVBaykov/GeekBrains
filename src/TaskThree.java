import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class TaskThree {
    public static void main(String[] args) throws IOException {
        ArrayList<InputStream> streams = new ArrayList<>();
        streams.add(new FileInputStream("testFiles\\one.txt"));
        streams.add(new FileInputStream("testFiles\\two.txt"));
        streams.add(new FileInputStream("testFiles\\three.txt"));
        streams.add(new FileInputStream("testFiles\\four.txt"));
        streams.add(new FileInputStream("testFiles\\five.txt"));

        SequenceInputStream sec = new SequenceInputStream(Collections.enumeration(streams));
        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File("testFiles\\compiledFile.txt")));

        int x;

        while ((x = sec.read()) != -1) {
            os.write(x);
        }

        sec.close();
        os.close();
    }
}
