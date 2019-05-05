package queue;

import exceptions.queue.EmptyQueueException;
import exceptions.queue.QueueOverloadException;

public interface Queue<E> {

    void add(E element);

    E remove();

    E peek();

    boolean isEmpty();

    boolean isFull();

    int size();

    default void isFullCheck() {
        if (isFull()) {
            throw new QueueOverloadException();
        }
    }

    default void isEmptyCheck() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
    }
}
