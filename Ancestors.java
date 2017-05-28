import java.util.ArrayList;

/**
 * Created by ioana-chirca on 28-May-17.
 */
public class Ancestors<T> {
    public ArrayList<T> printAncestors(BinaryTree<T> tree, T key) {
        ArrayList<T> ancs = new ArrayList<>();
        ancestors(tree.getRoot(), key, ancs);

        return ancs;
    }

    private boolean ancestors(BinaryTree.Node current, T key, ArrayList<T> ancs) {

        if (current == null) return false;
        if (current.getValue() == key) return true;

        if (ancestors(current.getLeft(), key, ancs) || ancestors(current.getRight(), key, ancs)) {
            System.out.println(current.getValue());
            ancs.add((T)current.getValue());
            return true;
        }

        return false;
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

        Ancestors<Integer> ancestors = new Ancestors<>();
        ancestors.printAncestors(tree, 5);
    }
}
