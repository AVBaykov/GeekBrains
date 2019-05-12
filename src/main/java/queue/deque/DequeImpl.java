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
    public void addFirst(E element) {
        isFullCheck();
        data[front++] = element;
        checkForFrontReset();
        size++;
    }

    @Override
    public void addLast(E element) {
        super.add(element);
    }

    @Override
    public E removeFirst() {
        return super.remove();
    }

    @Override
    public E removeLast() {
        isEmptyCheck();
        checkForRearReset();
        E removedValue = data[++rear];
        size--;
        return removedValue;
    }

}
