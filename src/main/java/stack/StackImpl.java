package stack;

import exceptions.stack.EmptyStackException;
import exceptions.stack.StackOverloadException;

public class StackImpl<E> implements Stack<E> {

    private E[] data;

    private int size;


    @SuppressWarnings("unchecked")
    public StackImpl(int capacity) {
        this.data = (E[]) new Object[capacity];
    }

    @Override
    public void push(E element) {
        try {
            data[size++] = element;
        } catch (IndexOutOfBoundsException e) {
            throw new StackOverloadException("stack.Stack is overloaded");
        }
    }

    @Override
    public E remove() {
        try {
            return data[--size];
        } catch (IndexOutOfBoundsException e) {
            throw  new EmptyStackException("remove");
        }
    }

    @Override
    public E peek() {
        try {
            return data[size - 1];
        } catch (IndexOutOfBoundsException e) {
            throw  new EmptyStackException("peek");
        }
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
