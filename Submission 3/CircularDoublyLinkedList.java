// Circular doubly linked list: tail.next wraps to head and head.prev wraps to tail.
public class CircularDoublyLinkedList {
    private static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head;
    private int size;

    public void insert(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = n;
            head.next = head.prev = head; // point to itself
        } else {
            Node tail = head.prev;
            n.next = head;
            n.prev = tail;
            tail.next = n;
            head.prev = n;
        }
        size++;
    }

    public boolean delete(int key) {
        if (head == null) return false;
        Node cur = head;
        do {
            if (cur.data == key) {
                if (size == 1) { head = null; }
                else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    if (cur == head) head = cur.next;
                }
                size--;
                return true;
            }
            cur = cur.next;
        } while (cur != head);
        return false;
    }

    public void display() {
        if (head == null) { System.out.println("empty"); return; }
        StringBuilder sb = new StringBuilder();
        Node cur = head;
        do {
            sb.append(cur.data).append(" <-> ");
            cur = cur.next;
        } while (cur != head);
        System.out.println(sb + "(back to head)");
    }

    public int size() { return size; }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insert(1); list.insert(2); list.insert(3);
        list.display();          // 1 <-> 2 <-> 3 <-> (back to head)
        list.delete(2);
        list.display();          // 1 <-> 3 <-> (back to head)
    }
}
