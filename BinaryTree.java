/**
 * Created by ioana-chirca on 28-May-17.
 */
public class BinaryTree<T> {
    public class Node {
        private T value;
        private Node left;
        private Node right;
        private Node parent;

        public Node() {}
        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }

        public Node(T value, Node parent) {
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = parent;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }
    }

    private Node root;

    public BinaryTree() {}
    public BinaryTree(T value) {
        root = new Node(value);
    }
    public BinaryTree(Node node) {
        root = node;
    }

    public void setRoot(T root) {
        this.root = new Node(root);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node search(T value, Node current) {
        if (current == null) return null;
        if (value == current.getValue()) {
            return current;
        }
        Node n = search(value, current.getLeft());
        if (n != null){
            return n;
        }
        n = search(value, current.getRight());
        return n;

    }

    public void insertChild(T parentValue, T value, boolean toLeft) {
        // adds value as a left/right child to parent
        // we assume that the keys are unique

        Node parent = search(parentValue, root);

        if (parent == null) return;
        if (toLeft && parent.getLeft() == null) {
            parent.setLeft(new Node(value, parent));
        } else if (!toLeft && parent.getRight() == null) {
            parent.setRight(new Node(value, parent));
        }
    }

    public void printTree() {
        printHelper(root, "");
    }

    private void printHelper(Node root, String indent) {
        if (root == null) {
            System.out.println(indent + "null");
            return;
        }

        String newIndent;
        if (indent.equals("")) {
            newIndent = ".. ";
        }
        else {
            newIndent = "..." + indent;
        }

        printHelper(root.getLeft(), newIndent);
        System.out.println(indent + root.getValue());
        printHelper(root.getRight(), newIndent);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.setRoot(16);
        tree.insertChild(16, 9, true);
        tree.insertChild(16, 18, false);
        tree.insertChild(9, 3, true);
        tree.insertChild(9, 14, false);
        tree.insertChild(3, 1, true);
        tree.insertChild(3, 5, false);
        tree.insertChild(18, 19, false);

        tree.printTree();
    }
}
