package exceptions.stack;

public class EmptyStackException extends RuntimeException {
    public EmptyStackException(String s) {
        super(String.format("Trying to %s from empty stack", s));
    }
}
