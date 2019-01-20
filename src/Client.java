import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner out;

        Scanner in;

        PrintWriter writer;

        try (Socket socket = new Socket("localhost", 8189)) {
            out = new Scanner(System.in);
            in = new Scanner(socket.getInputStream());

            writer = new PrintWriter(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    String receive = in.nextLine();
                    System.out.println(receive);
                }
            }).start();

            while (true) {
                String send = out.nextLine();
                writer.println(send);
                writer.flush();
            }

        } catch (IOException ex) {
            System.out.println("It's a trap! (c) Admiral Ackbar");
            ex.printStackTrace();
        }
    }
}
