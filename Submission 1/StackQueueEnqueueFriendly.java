// Queue implemented using two stacks - ENQUEUE friendly (enqueue O(1))
// enqueue: O(1). dequeue: O(n) when out stack needs refilling.
import java.util.Stack;

public class StackQueueEnqueueFriendly {
    private Stack<Integer> in = new Stack<>();  // handles enqueue
    private Stack<Integer> out = new Stack<>(); // handles dequeue

    public void enqueue(int x) {
        in.push(x); // O(1)
    }

    public int dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        shiftIfNeeded();
        return out.pop();
    }

    public int peek() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        shiftIfNeeded();
        return out.peek();
    }

    private void shiftIfNeeded() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop()); // reverse order once
        }
    }

    public boolean isEmpty() { return in.isEmpty() && out.isEmpty(); }
    public int size() { return in.size() + out.size(); }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly q = new StackQueueEnqueueFriendly();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println("Dequeue: " + q.dequeue()); // 1
        q.enqueue(4);
        System.out.println("Dequeue: " + q.dequeue()); // 2
        System.out.println("Peek: " + q.peek());       // 3
    }
}
