public interface Array<E> {

    void add(E element);

    boolean remove(E element);

    void remove(int index);

    boolean contains(E element);

    int indexOf(E element);

    int size();

    boolean isEmpty();

    E get(int index);

    void bubbleSort();

    void sortSelect();

    void sortInsert();

    Array<E> getCopy();
}
