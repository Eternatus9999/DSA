// Queue implemented using two stacks - DEQUEUE friendly (amortized O(1) dequeue)
// enqueue: O(n) (rebuild order each time). dequeue: O(1).
import java.util.Stack;

public class StackQueueDequeueFriendly {
    private Stack<Integer> s1 = new Stack<>(); // front of queue at top
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x) {
        while (!s1.isEmpty()) s2.push(s1.pop()); // empty front stack
        s1.push(x);                              // new element at bottom
        while (!s2.isEmpty()) s1.push(s2.pop()); // restore order
    }

    public int dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        return s1.pop(); // O(1)
    }

    public int peek() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        return s1.peek();
    }

    public boolean isEmpty() { return s1.isEmpty(); }
    public int size() { return s1.size(); }

    public static void main(String[] args) {
        StackQueueDequeueFriendly q = new StackQueueDequeueFriendly();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println("Dequeue: " + q.dequeue()); // 1
        q.enqueue(4);
        System.out.println("Dequeue: " + q.dequeue()); // 2
        System.out.println("Peek: " + q.peek());       // 3
    }
}
