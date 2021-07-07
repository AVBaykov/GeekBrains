package Lesson_6.Server;

import Lesson_6.Client.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class ServerTest {

    private Hashtable<String, ClientHandler> clients;

    public ServerTest() {
        clients = new Hashtable<>();
        Socket socket = null;

        try (ServerSocket server = new ServerSocket(8189)) {
            System.out.println("Сервер запущен!");

            while (true) {
                    socket = server.accept();
                    System.out.println("Клиент подключился");
                    new ClientHandler(this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void subscribe(String nick, ClientHandler client) {
        clients.put(nick, client);
    }

    public void unsubscribe(String nick) {
        clients.remove(nick);
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o : clients.values()) {
            o.sendMsg(msg);
        }
    }

    public void unicastMsg(ClientHandler clientHandler, String nick, String msg) {
        clients.get(nick).sendMsg(clientHandler.getNick() + " to you: " + msg);
        clientHandler.sendMsg("you to + " + nick + ": " + msg);
    }

    public boolean isAlreadyExists(String nick) {
        return clients.containsKey(nick);
    }
}
