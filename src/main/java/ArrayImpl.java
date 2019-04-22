import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayImpl<E extends Object & Comparable<? super E>> extends AbstractArray<E> {


    public ArrayImpl() {
        super();
    }

    public ArrayImpl(ArrayImpl<E> eArray) {
        this.data = Arrays.copyOf(eArray.data, eArray.size);
        this.size = eArray.size;
    }

    @Override
    public void add(E element) {
        if (size == data.length) {
            growArray();
        }
        data[size++] = element;
    }

    private void growArray() {
        data = Arrays.copyOf(data, data.length * 2);
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);

        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public void remove(int index) {
        size--;
        System.arraycopy(data, index + 1, data, index, size - index);
        data[size] = null;
    }

    @Override
    public boolean contains(E element) {
        for (E e : data) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) <= 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];

            int in = i;
            while (in > 0 && data[in - 1].compareTo(temp) >= 0) {
                data[in] = data[in - 1];
                in--;
            }

            data[in] = temp;
        }
    }

    private void swap(int index1, int index2) {
        E temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    @Override
    public ArrayImpl<E> getCopy() {
        return new ArrayImpl<>(this);
    }

    @Override
    public String toString() {
        return Stream.of(data).limit(size).map(String::valueOf).collect(Collectors.joining(", "));
    }
}
