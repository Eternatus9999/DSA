// Stack implemented using two queues - PUSH friendly (push O(1))
// Push: O(1). Pop: O(n) - rearrange elements so the newest ends up at front of q1.
import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q1.offer(x); // simple O(1) push
    }

    public int pop() {
        if (q1.isEmpty()) throw new java.util.NoSuchElementException("Stack is empty");
        // Move all but last element to q2
        while (q1.size() > 1) q2.offer(q1.poll());
        int top = q1.poll();
        // Swap queues
        Queue<Integer> tmp = q1; q1 = q2; q2 = tmp;
        return top;
    }

    public int peek() {
        if (q1.isEmpty()) throw new java.util.NoSuchElementException("Stack is empty");
        while (q1.size() > 1) q2.offer(q1.poll());
        int top = q1.poll();
        q2.offer(top); // put it back
        Queue<Integer> tmp = q1; q1 = q2; q2 = tmp;
        return top;
    }

    public boolean isEmpty() { return q1.isEmpty(); }
    public int size() { return q1.size(); }

    public static void main(String[] args) {
        QueueStackPushFriendly s = new QueueStackPushFriendly();
        s.push(10); s.push(20); s.push(30);
        System.out.println("Pop: " + s.pop());   // 30
        System.out.println("Peek: " + s.peek()); // 20
        System.out.println("Pop: " + s.pop());   // 20
        System.out.println("Size: " + s.size()); // 1
    }
}
