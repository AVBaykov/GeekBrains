package gb.message;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для того, чтобы кэшировать последние 100 сообщений. Не нужно каждый раз читать сообщения из файла.
 */
public class MessageCache {

    private static final LinkedList<Message> CACHE = new LinkedList<>();

    public static class MessageCacheHolder {
        public static final MessageCache HOLDER_INSTANCE = new MessageCache();
    }

    public static MessageCache getInstance() {
        return MessageCacheHolder.HOLDER_INSTANCE;
    }

    /**
     * Добавляет сообщение в кэш. При достижении лимита в 100 сообщений удаляет последнее и добавляет новое
     * в начало кэша.
     * @param message Сообщение, которое содержит в себе ник и текст самого сообщения.
     */
    public static void add(Message message) {
        if (CACHE.size() == 100) {
            CACHE.removeLast();
        }
        CACHE.addFirst(message);
    }

    /**
     *
     * @return возврщает сообщения из кэша
     */
    public static LinkedList<Message> getCACHE() {
        return CACHE;
    }

}
