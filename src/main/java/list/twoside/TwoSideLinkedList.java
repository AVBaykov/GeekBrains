package list.twoside;

import list.LinkedList;

public interface TwoSideLinkedList<E> extends LinkedList<E> {

    void insertRight(E value);

    E removeLeft();
}
