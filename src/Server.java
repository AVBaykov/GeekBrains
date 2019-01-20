import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        Socket socket;

        Scanner in;
        Scanner out;

        PrintWriter writer;

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server is up. W8 for connection");

            socket = serverSocket.accept();
            System.out.println("Client has been connected");

            in = new Scanner(socket.getInputStream());
            out = new Scanner(System.in);
            writer = new PrintWriter(socket.getOutputStream());

            new Thread(() -> {
                while (true) {
                    String receive = in.nextLine();
                    if (receive.equals("end")) {
                        break;
                    }
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
