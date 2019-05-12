import list.LinkedListImpl;
import list.iterator.ListIterator;
import list.twoside.TwoSideLinkedList;

public class Main {
    public static void main(String[] args) {

        TwoSideLinkedList<Integer> list = new LinkedListImpl<>();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);


        ListIterator<Integer> iterator = (ListIterator<Integer>) list.iterator();

        iterator.insertBefore(123);
        iterator.insertBefore(124);

        list.display();
    }
}
