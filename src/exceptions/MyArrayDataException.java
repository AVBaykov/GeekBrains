package exceptions;

public class MyArrayDataException extends Exception {

    public MyArrayDataException(String s, int i, int j) {
        super(String.format(s, i, j));
    }
}
