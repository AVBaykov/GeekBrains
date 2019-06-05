package gb.server;

import gb.message.Message;
import gb.message.MessageCache;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;
    private static final String SPLITTER = ": \\u2063";
    private static final File LOG_FILE = new File("log\\log.txt");

    static {
        if (LOG_FILE.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
                while (reader.ready()) {
                    String[] line = reader.readLine().split(SPLITTER);
                    MessageCache.add(new Message(line[0], line[1]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Server() throws SQLException {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            AuthService.connect();
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен. Ожидаем клиентов...");
            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket, writer);
                // clients.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }


    public void broadcastMsg(Message message) {
        for (ClientHandler o : clients) {
            o.sendMsg(message.getMessageToSend());
        }
    }
}
