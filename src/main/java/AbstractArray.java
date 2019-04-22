public abstract class AbstractArray<E> implements Array<E> {

    private static final int DEFAULT_CAPACITY = 8;
    protected E[] data;
    protected int size;


    public AbstractArray() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public AbstractArray(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int index) {
        if (index < 0 && index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }
}
