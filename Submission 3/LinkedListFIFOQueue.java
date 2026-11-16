// FIFO queue implemented with a singly linked list (head = front, tail = rear).
public class LinkedListFIFOQueue {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public void enqueue(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; }
        else { tail.next = n; tail = n; }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        int val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        return head.data;
    }

    public boolean isEmpty() { return head == null; }
    public int size() { return size; }

    public static void main(String[] args) {
        LinkedListFIFOQueue q = new LinkedListFIFOQueue();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println("Dequeue: " + q.dequeue()); // 1
        q.enqueue(4);
        System.out.println("Peek: " + q.peek());       // 2
        System.out.println("Size: " + q.size());       // 3
    }
}
