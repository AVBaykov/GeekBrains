package queue.deque;

import queue.Queue;

public interface Deque<E> extends Queue<E> {

    void addFirst(E element);

    void addLast(E element);

    E removeFirst();

    E removeLast();
}
