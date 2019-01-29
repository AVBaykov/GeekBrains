package Lesson_6.Client;

import Lesson_6.Server.AuthService;
import Lesson_6.Server.ServerTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private ServerTest server;
    private String nick;

    public ClientHandler(ServerTest server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
                try {
                    long currentTime = System.currentTimeMillis();
                    long authorizeTime = currentTime + 5_000;
                    String str;
                    while (System.currentTimeMillis() < authorizeTime && !(str = in.readUTF()).isEmpty()) {

                        if (str.startsWith("/auth")) {
                            String[] tokens = str.split(" ");
                            String newNick = AuthService.getNickLoginAndPass(tokens[1], tokens[2]);
                            if (newNick != null) {
                                if (!server.isAlreadyExists(newNick)) {
                                    sendMsg("/authok");
                                    nick = newNick;
                                    server.subscribe(nick, ClientHandler.this);
                                    break;
                                } else {
                                    sendMsg("Пользователь с таким ником уже вошел в чат");
                                }
                            } else {
                                sendMsg("Неверный логин/пароль!");
                            }
                        }
                    }

                    if (nick != null) {
                        sendMsg("Клиент отключен");
                        return;
                    }
                    while (true) {
                        str = in.readUTF();
                        if (str.equals("/end")) {
                            out.writeUTF("/serverClosed");
                            break;
                        }
                        if (str.startsWith("/w")) {
                            String[] tokens = str.split(" ", 3);
                            server.unicastMsg(ClientHandler.this, tokens[1], tokens[2]);
                        } else {
                            server.broadcastMsg(nick + ": " + str);
                        }
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
                    server.unsubscribe(nick);
                }

            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNick() {
        return nick;
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
