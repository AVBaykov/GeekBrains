package gb.message;

public class Message {

    private String nick;
    private String message;
    private static final String SEPARATOR = "\u2063";

    public Message(String nick, String message) {
        this.nick = nick;
        this.message = message;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageToSend() {
        return String.format("%s: %s", nick, message);
    }

    public String getMessageToWrite() {
        return String.format("%s: %s%s\n", nick, SEPARATOR, message);
    }
}
