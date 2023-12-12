package classicaglo;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        // Create sentinel nodes without data
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFront(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    public void addBack(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public void remove(T data) {
        Node<T> current = head.next;
        while (current != tail) {
            if (current.data.equals(data)) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void display() {
        Node<T> current = head.next;
        while (current != tail) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);
        list.addFront(0);
        list.display(); // Output: 0 <-> 1 <-> 2 <-> 3 <-> null

        list.remove(2);
        list.display(); // Output: 0 <-> 1 <-> 3 <-> null
        System.out.println("Size: " + list.size()); // Output: Size: 3
    }
}
