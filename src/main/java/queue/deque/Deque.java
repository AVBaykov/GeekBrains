package queue.deque;

import queue.Queue;

public interface Deque<E> extends Queue<E> {

    void addLeft(E element);

    void addRight(E element);

    E removeLeft();

    E removeRight();
}
