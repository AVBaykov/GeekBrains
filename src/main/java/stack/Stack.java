package stack;

public interface Stack<E> {

    void push(E element);

    E remove();

    E peek();

    boolean isFull();

    boolean isEmpty();

    int size();
}
