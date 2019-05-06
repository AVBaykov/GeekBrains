import stack.Stack;
import stack.StackImpl;

public class StringReverser {

    public static String reverseString(String string) {
        char[] chars = string.toCharArray();
        Stack<Character> characterStack = new StackImpl<>(chars.length);

        for (char c : chars) {
            characterStack.push(c);
        }

        for (int i = 0; i < chars.length; i++) {
            chars[i] = characterStack.remove();
        }

        return new String(chars);
    }
}
