/**
 * Created by ioana-chirca on 16-May-17.
 */
public class LinkedList {
    public class Node {
        private int value;
        private Node next;

        public Node() {}

        public Node(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
    }

    public int getSize() {
        return size;
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value);
            size++;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            Node node = new Node(value);
            current.setNext(node);
            size++;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    public int getKthToLast(int k) {
        if (k < 0 || k >= size)
            return Integer.MIN_VALUE; // suppose this value cannot be in the list
        Node fast = head;
        int ran = 0;
        while (ran < k) {
            fast = fast.getNext();
            ran++;
        }
        Node slow = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow.getValue();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 0; i < 10; i++) {
            list.addLast(i);
        }
        list.printList();

        for (int i = -1; i < list.getSize() + 3; i++) {
            System.out.println(i + " -> " + list.getKthToLast(i));
        }
    }
}
