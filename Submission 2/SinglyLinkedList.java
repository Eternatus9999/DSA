// Singly linked list with insert, delete, search and display.
public class SinglyLinkedList {
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void insertAtBeginning(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
        size++;
    }

    public void insertAtEnd(int x) {
        Node n = new Node(x);
        if (head == null) { head = n; }
        else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = n;
        }
        size++;
    }

    public void insertAt(int index, int x) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) { insertAtBeginning(x); return; }
        Node cur = head;
        for (int i = 0; i < index - 1; i++) cur = cur.next;
        Node n = new Node(x);
        n.next = cur.next;
        cur.next = n;
        size++;
    }

    public boolean delete(int key) {
        if (head == null) return false;
        if (head.data == key) { head = head.next; size--; return true; }
        Node cur = head;
        while (cur.next != null && cur.next.data != key) cur = cur.next;
        if (cur.next == null) return false;
        cur.next = cur.next.next;
        size--;
        return true;
    }

    public boolean search(int key) {
        for (Node cur = head; cur != null; cur = cur.next)
            if (cur.data == key) return true;
        return false;
    }

    public void display() {
        StringBuilder sb = new StringBuilder();
        for (Node cur = head; cur != null; cur = cur.next) sb.append(cur.data).append(" -> ");
        System.out.println(sb + "null");
    }

    public int size() { return size; }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(10); list.insertAtBeginning(5); list.insertAt(2, 15);
        list.display();              // 5 -> 10 -> 15 -> null
        list.delete(10);
        list.display();              // 5 -> 15 -> null
        System.out.println("Search 15: " + list.search(15)); // true
    }
}
