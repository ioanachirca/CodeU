/**
 * Created by ioana-chirca on 28-May-17.
 */
import org.junit.Assert;
import org.junit.Before;
public class LowestCommonAncestor {
    public static BinaryTree.Node findLCA(BinaryTree.Node node1, BinaryTree.Node node2) {
        // 1. determine node depths
        // 2. advance the lower node by the difference
        // 3. advance both nodes until they reach the same node

        if (node1 == null || node2 == null) return null;

        int depth1 = depth(node1);
        int depth2 = depth(node2);
        if (depth1 > depth2) {
            node1 = advance(node1, depth1 - depth2);
        } else if (depth2 > depth1) {
            node2 = advance(node2, depth2 - depth1);
        }

        while (node1 != null && node2 != null && node1 != node2) {
            node1 = node1.getParent();
            node2 = node2.getParent();
        }

        // node1 (or node2) will now contain the LCA or null
        return node1;

    }

    private static int depth (BinaryTree.Node node) {
        if (node == null) return -1;
        int depth = 0;
        while (node != null) {
            node = node.getParent();
            depth++;
        }
        return depth;
    }

    private static BinaryTree.Node advance(BinaryTree.Node node, int steps) {
        while (steps > 0 && node != null) {
            node = node.getParent();
            steps--;
        }
        return node;
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

        BinaryTree.Node node1 = tree.search(1, tree.getRoot());
        BinaryTree.Node node2 = tree.search(9, tree.getRoot());

        System.out.println(findLCA(node1, node2).getValue());
    }
}
