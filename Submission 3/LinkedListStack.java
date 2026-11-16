// Stack implemented on top of a singly linked list (top = head).
public class LinkedListStack {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node top;
    private int size;

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
        size++;
    }

    public int pop() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Stack is empty");
        int val = top.data;
        top = top.next;
        size--;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() { return top == null; }
    public int size() { return size; }

    public static void main(String[] args) {
        LinkedListStack s = new LinkedListStack();
        s.push(10); s.push(20); s.push(30);
        System.out.println("Pop: " + s.pop());   // 30
        System.out.println("Peek: " + s.peek()); // 20
        System.out.println("Size: " + s.size()); // 2
    }
}
