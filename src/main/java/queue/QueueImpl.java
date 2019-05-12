package queue;

public class QueueImpl<E> implements Queue<E> {

    protected static final int DEFAULT_FRONT = 0;
    protected static final int DEFAULT_REAR = -1;

    protected E[] data;
    protected int size;

    protected int front;
    protected int rear;

    @SuppressWarnings("unchecked")
    public QueueImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
        front = DEFAULT_FRONT;
        rear = DEFAULT_REAR;
    }

    protected QueueImpl(E[] data) {
        this.data = data;
    }


    @Override
    public void add(E element) {
        isFullCheck();
        checkForRearReset();
        data[++rear] = element;
        size++;
    }

    protected void checkForRearReset() {
        if (rear == data.length - 1) {
            rear = DEFAULT_REAR;
        }
    }

    @Override
    public E remove() {
        isEmptyCheck();
        checkForFrontReset();
        E removedValue = data[front++];
        size--;
        return removedValue;
    }

    protected void checkForFrontReset() {
        if (front == data.length) {
            front = DEFAULT_FRONT;
        }
    }


    @Override
    public E peek() {
        return data[front];
    }

    @Override
    public boolean isFull() {
        return data.length == size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
