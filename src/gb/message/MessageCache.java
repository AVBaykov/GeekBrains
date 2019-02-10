package gb.message;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MessageCache {

    private static final LinkedList<Message> CACHE = new LinkedList<>();

    public static class MessageCacheHolder {
        public static final MessageCache HOLDER_INSTANCE = new MessageCache();
    }

    public static MessageCache getInstance() {
        return MessageCacheHolder.HOLDER_INSTANCE;
    }


    public static void add(Message message) {
        if (CACHE.size() == 100) {
            CACHE.removeLast();
        }
        CACHE.addFirst(message);
    }

    public static LinkedList<Message> getCACHE() {
        return CACHE;
    }
    
    public static void addAll(List<Message> messageList) {
        List<Message> temp = messageList.size() > 100 ? messageList.stream().limit(100).collect(Collectors.toList()) : messageList;
        CACHE.addAll(temp);
    }
}
