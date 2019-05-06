package queue.deque;

import queue.QueueImpl;

public class DequeImpl<E> extends QueueImpl<E> implements Deque<E> {


    public DequeImpl(int capacity) {
        super(capacity);
    }

    protected DequeImpl(E[] data) {
        super(data);
    }

    @Override
    public void addLeft(E element) {
        isFullCheck();
        if (front - 1 < 0) {
            front = data.length;
        }
        data[--front] = element;
        size++;
    }

    @Override
    public void addRight(E element) {
        super.add(element);
    }

    @Override
    public E removeLeft() {
        return super.remove();
    }

    @Override
    public E removeRight() {
        isEmptyCheck();
        if (rear < 0) {
            rear = data.length - 1;
        }
        size--;
        return data[rear--];
    }

}
