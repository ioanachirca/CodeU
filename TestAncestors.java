import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ioana-chirca on 29-May-17.
 */
public class TestAncestors {
    private BinaryTree<Integer> tree = new BinaryTree<>();
    private Ancestors<Integer> ancestors = new Ancestors<>();

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
    public void testNormal1() {
        ArrayList<Integer> ancs = ancestors.printAncestors(tree, 5);
        Integer[] expected = {3, 9, 16};
        Assert.assertArrayEquals(ancs.toArray(), expected);
    }

    @org.junit.Test
    public void testNormal2() {
        ArrayList<Integer> ancs = ancestors.printAncestors(tree, 19);
        Integer[] expected = {18, 16};
        Assert.assertArrayEquals(ancs.toArray(), expected);
    }

    @org.junit.Test
    public void testRoot() {
        ArrayList<Integer> ancs = ancestors.printAncestors(tree, 16);
        Integer[] expected = {};
        Assert.assertArrayEquals(ancs.toArray(), expected);
    }

    @org.junit.Test
    public void testAbsentNode() {
        ArrayList<Integer> ancs = ancestors.printAncestors(tree, 10);
        Integer[] expected = {};
        Assert.assertArrayEquals(ancs.toArray(), expected);
    }

    @After
    public void tearDown() {
        tree = null;
        ancestors = null;
    }
}
