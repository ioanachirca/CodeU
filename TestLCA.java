import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by ioana-chirca on 29-May-17.
 */
public class TestLCA {
    private BinaryTree<Integer> tree = new BinaryTree<>();
    private LowestCommonAncestor lca = new LowestCommonAncestor();

    @Before
    public void setUp() {
        tree.setRoot(16);
        tree.insertChild(16, 9, true);
        tree.insertChild(16, 18, false);
        tree.insertChild(9, 3, true);
        tree.insertChild(9, 14, false);
        tree.insertChild(3, 1, true);
        tree.insertChild(3, 5, false);
        tree.insertChild(18, 19, false);
    }

    @org.junit.Test
    public void testNormal() {
        BinaryTree.Node node1 = tree.search(5, tree.getRoot());
        BinaryTree.Node node2 = tree.search(14, tree.getRoot());
        Assert.assertTrue(lca.findLCA(node1, node2).getValue().equals(9));
    }

    @org.junit.Test
    public void testNodeIsParent() {
        BinaryTree.Node node1 = tree.search(18, tree.getRoot());
        BinaryTree.Node node2 = tree.search(19, tree.getRoot());
        Assert.assertTrue(lca.findLCA(node1, node2).getValue().equals(18));
    }

    @org.junit.Test
    public void testSameNodes() {
        BinaryTree.Node node1 = tree.search(3, tree.getRoot());
        BinaryTree.Node node2 = tree.search(3, tree.getRoot());
        Assert.assertTrue(lca.findLCA(node1, node2).getValue().equals(3));
    }

    @org.junit.Test
    public void testAbsentNode() {
        BinaryTree.Node node1 = tree.search(6, tree.getRoot());
        BinaryTree.Node node2 = tree.search(3, tree.getRoot());
        Assert.assertTrue(lca.findLCA(node1, node2) == null);
    }

    @After
    public void tearDown() {
        tree = null;
        lca = null;
    }



}
