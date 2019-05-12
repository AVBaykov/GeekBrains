package list;

import list.iterator.ListIterator;
import list.twoside.TwoSideLinkedList;

import java.util.Iterator;
import java.util.Optional;

public class LinkedListImpl<E> implements TwoSideLinkedList<E> {

    private Entry<E> last;
    private Entry<E> first;
    private int size;


    @Override
    public void insert(E value) {
        insertLeft(value);
    }

    @Override
    public E remove() {
        E element = Optional.ofNullable(first.value).orElse(null);
        if (element != null) {
            first = first.next;
            size--;
        }
        return element;
    }

    @Override
    public boolean remove(E value) {
        Entry<E> current = first;
        Entry<E> prev = null;
        while (current != null) {
            if (current.value.equals(value)) {
                break;
            }

            prev = current;
            current = current.next;
        }
        if (current == null) {
            return false;
        }

        if (current == first) {
            first = current.next;
        } else if (current == last) {
            last = prev;
            prev.next = null;
        } else {
            prev.next = current.next;
        }
        size--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean find(E value) {
        return doFind(value) != null;
    }

    private Entry<E> doFind(E value) {
        Entry<E> current = first;
        while (current != null) {
            if (current.value.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public void display() {
        System.out.println("------");
        System.out.println("display " + this.getClass().getSimpleName());

        Entry<E> current = first;

        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }

        System.out.println("------");
    }

    @Override
    public E getFirstElement() {
        return first.value;
    }


    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    public LinkedListIterator getIterator() {
        return new LinkedListIterator();
    }

    private void insertLeft(E value) {
        first = new Entry<>(value, first);
        size++;
        if (size == 1) {
            last = first;
        }
    }

    @Override
    public void insertRight(E value) {
        Entry<E> newElement = new Entry<>(value, null);
        if (isEmpty()) {
            first = newElement;
        } else {
            last.next = newElement;
        }

        last = newElement;
        size++;
    }

    @Override
    public E removeLeft() {
        E removedValue = remove();
        if (isEmpty()) {
            last = null;
        }
        return removedValue;
    }

    private static class Entry<E> {

        E value;
        Entry<E> next;

        Entry(E value, Entry<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private class LinkedListIterator implements ListIterator<E> {

        private Entry<E> lastReturned;
        private Entry<E> next = first;
        private int nextIndex;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                return null;
            }
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.value;
        }


        @Override
        public E getCurrent() {
            return next.value;
        }

        @Override
        public void insertAfter(E value) {
            Entry<E> newEntry = new Entry<>(value, null);
            if (isEmpty()) {
                first = newEntry;
                lastReturned = newEntry;
            } else {
                newEntry.next = next.next;
                next.next = newEntry;
                next();
            }
        }

        @Override
        public void insertBefore(E value) {
            Entry<E> newItem = new Entry<>(value, null);
            if(lastReturned == null) {
                newItem.next = first;
                first = newItem;
                reset();
            }
            else {
                newItem.next = lastReturned.next;
                lastReturned.next = newItem;
                next = newItem;
            }
        }

        @Override
        public void reset() {
            lastReturned = null;
            next = first;
            nextIndex = 0;
        }

    }

}
