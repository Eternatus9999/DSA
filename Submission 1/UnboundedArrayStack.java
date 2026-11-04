// Stack backed by an array that grows on push (doubling) and shrinks on pop
// (halving when quarter full) so memory stays proportional to size.
import java.util.Arrays;
import java.util.NoSuchElementException;

public class UnboundedArrayStack {
    private int[] arr;
    private int top; // number of elements

    public UnboundedArrayStack() {
        arr = new int[4];
        top = 0;
    }

    public void push(int x) {
        if (top == arr.length) resize(2 * arr.length); // grow
        arr[top++] = x;
    }

    public int pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        int val = arr[--top];
        arr[top] = 0; // avoid loitering
        if (top > 0 && top == arr.length / 4) resize(arr.length / 2); // shrink
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return arr[top - 1];
    }

    private void resize(int capacity) {
        arr = Arrays.copyOf(arr, capacity);
    }

    public boolean isEmpty() { return top == 0; }
    public int size() { return top; }
    public int capacity() { return arr.length; }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        for (int i = 1; i <= 10; i++) s.push(i); // grows 4 -> 8 -> 16
        System.out.println("Size: " + s.size() + ", Capacity: " + s.capacity());
        while (s.size() > 2) s.pop();            // shrinks back down
        System.out.println("Size: " + s.size() + ", Capacity: " + s.capacity());
        System.out.println("Peek: " + s.peek());
    }
}
