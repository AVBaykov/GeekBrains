package gb.server;

import gb.message.Message;
import gb.message.MessageCache;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.ListIterator;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private String nick;
    private BufferedWriter writer;

    public ClientHandler(Server server, Socket socket, BufferedWriter writer) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.writer = writer;
            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.readUTF();
                        if (str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                            if (newNick != null) {
                                sendMsg("/authok");
                                nick = newNick;
                                server.subscribe(this);
                                getLastMessages();
                                break;
                            } else {
                                sendMsg("Неверный логин/пароль");
                            }
                        }
                    }
                    while (true) {
                        String str = in.readUTF();
                        if (str.equals("/end")) {
                            out.writeUTF("/serverclosed");
                            break;
                        }
                        Message message = new Message(nick, str);
                        server.broadcastMsg(message);
                        MessageCache.add(message);
                        this.writer.write(message.getMessageToWrite());
                        this.writer.flush();
                        System.out.println("Client: " + str);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    server.unsubscribe(this);
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Распечатывает историю чата из кэша сообщений подключившемуся клиенту.
     */
    private void getLastMessages() {
        LinkedList<Message> list = MessageCache.getCACHE();
        ListIterator<Message> iterator = list.listIterator(list.size());
        while (iterator.hasPrevious()) {
            sendMsg(iterator.previous().getMessageToSend());
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
