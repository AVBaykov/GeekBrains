package list.iterator;

import java.util.Iterator;

public interface ListIterator<E> extends Iterator<E> {

    E getCurrent();

    void insertAfter(E value);

    void insertBefore(E value);

    void reset();

}
