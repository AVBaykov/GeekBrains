package exceptions.queue;

public class QueueOverloadException extends RuntimeException {

    public QueueOverloadException() {
        super("Queue overloaded");
    }
}
