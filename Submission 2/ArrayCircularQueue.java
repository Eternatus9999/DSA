// Circular queue backed by a fixed-size array using front/rear indices with wraparound.
import java.util.NoSuchElementException;

public class ArrayCircularQueue {
    private int[] arr;
    private int front, rear, count;

    public ArrayCircularQueue(int capacity) {
        arr = new int[capacity];
        front = 0; rear = -1; count = 0;
    }

    public void enqueue(int x) {
        if (count == arr.length) throw new IllegalStateException("Queue is full");
        rear = (rear + 1) % arr.length; // wrap around
        arr[rear] = x;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        int val = arr[front];
        front = (front + 1) % arr.length; // wrap around
        count--;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return arr[front];
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == arr.length; }
    public int size() { return count; }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue(4);
        q.enqueue(1); q.enqueue(2); q.enqueue(3); q.enqueue(4);
        System.out.println("Dequeue: " + q.dequeue()); // 1 (frees a slot via wraparound)
        q.enqueue(5);
        while (!q.isEmpty()) System.out.print(q.dequeue() + " "); // 2 3 4 5
        System.out.println();
    }
}
