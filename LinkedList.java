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
    private Node last;
    private int size;

    public LinkedList() {
    }

    public int getSize() {
        return size;
    }

    public void addLast(int value) {
        if (head == null) {
            head = new Node(value);
            last = head;
        } else {
            Node current = new Node(value);
            last.setNext(current);
            last = current;
        }
        size++;
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

        // this loop tests different k's
        // the expected output is MIN 9 8 7 6 5 4 3 2 1 0 MIN
        // MIN is printed when k exceeds the list length or is negative
        for (int i = -1; i < list.getSize() + 1; i++) {
            System.out.println(i + " -> " + list.getKthToLast(i));
        }
    }
}
