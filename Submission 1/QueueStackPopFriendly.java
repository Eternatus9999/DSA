// Stack implemented using two queues - POP friendly (pop O(1))
// Push: O(n) - new element placed at front by rotating. Pop: O(1).
import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.offer(x);
        while (!q1.isEmpty()) q2.offer(q1.poll()); // move old elements behind new one
        Queue<Integer> tmp = q1; q1 = q2; q2 = tmp; // q1 now behaves as stack top
    }

    public int pop() {
        if (q1.isEmpty()) throw new java.util.NoSuchElementException("Stack is empty");
        return q1.poll(); // O(1)
    }

    public int peek() {
        if (q1.isEmpty()) throw new java.util.NoSuchElementException("Stack is empty");
        return q1.peek();
    }

    public boolean isEmpty() { return q1.isEmpty(); }
    public int size() { return q1.size(); }

    public static void main(String[] args) {
        QueueStackPopFriendly s = new QueueStackPopFriendly();
        s.push(10); s.push(20); s.push(30);
        System.out.println("Pop: " + s.pop());   // 30
        System.out.println("Peek: " + s.peek()); // 20
        System.out.println("Pop: " + s.pop());   // 20
        System.out.println("Size: " + s.size()); // 1
    }
}
