// Doubly linked list with prev/next pointers, insert, delete, search and display.
public class DoublyLinkedList {
    private static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public void insertAtEnd(int x) {
        Node n = new Node(x);
        if (tail == null) { head = tail = n; }
        else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    public void insertAtBeginning(int x) {
        Node n = new Node(x);
        if (head == null) { head = tail = n; }
        else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;
    }

    public boolean delete(int key) {
        Node cur = head;
        while (cur != null && cur.data != key) cur = cur.next;
        if (cur == null) return false;
        if (cur.prev != null) cur.prev.next = cur.next; else head = cur.next;
        if (cur.next != null) cur.next.prev = cur.prev; else tail = cur.prev;
        size--;
        return true;
    }

    public boolean search(int key) {
        for (Node cur = head; cur != null; cur = cur.next)
            if (cur.data == key) return true;
        return false;
    }

    public void displayForward() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" <-> ");
        System.out.println(sb + "null");
    }

    public void displayBackward() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = tail; cur != null; cur = cur.prev) sb.append(cur.data).append(" <-> ");
        System.out.println(sb + "null");
    }

    public int size() { return size; }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(10); list.insertAtEnd(20); list.insertAtBeginning(5);
        list.displayForward();  // 5 <-> 10 <-> 20 <-> null
        list.displayBackward(); // 20 <-> 10 <-> 5 <-> null
        list.delete(10);
        list.displayForward();  // 5 <-> 20 <-> null
        System.out.println("Search 20: " + list.search(20)); // true
    }
}
