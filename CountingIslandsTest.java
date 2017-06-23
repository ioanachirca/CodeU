import org.junit.Assert;

/**
 * Created by ioana-chirca on 23-Jun-17.
 */
public class CountingIslandsTest {
    @org.junit.Test
    public void testNormalRecursive() {
        boolean[][] grid = {{false, true, false, true},
                {true, true, false, false},
                {false, false, true, false},
                {false, false, true, false}};
        int rows = 4;
        int columns = 4;
        Assert.assertEquals(3, CountingIslands.recursiveCount(rows, columns, grid));
    }

    @org.junit.Test
    public void testNormalLinear() {
        boolean[][] grid = {{false, true, false, true},
                {true, true, false, false},
                {false, false, true, false},
                {false, false, true, false}};
        int rows = 4;
        int columns = 4;
        Assert.assertEquals(3, CountingIslands.linearCount(rows, columns, grid));
    }

    @org.junit.Test
    public void testOneIslandRecursive() {
        boolean[][] grid = {{true, true},
                            {true, true}};
        int rows = 2;
        int columns = 2;
        Assert.assertEquals(1, CountingIslands.recursiveCount(rows, columns, grid));
    }

    @org.junit.Test
    public void testOneIslandLinear() {
        boolean[][] grid = {{true, true},
                            {true, true}};
        int rows = 2;
        int columns = 2;
        Assert.assertEquals(1, CountingIslands.linearCount(rows, columns, grid));
    }

    @org.junit.Test
    public void testBiggerRecursive() {
        boolean[][] grid = {{true, false, false, false, true, true, false, false, false, false},
                            {true, true, false, true, false, true, false, true, true, true},
                            {false, true, true, false, false, true, true, false, false, true},
                            {true, false, false, false, true, false, false, true, false, true},
                            {true, true, true, false, true, true, true, true, false, true},
                            {false, true, true, false, false, true, true, false, false, true},
                            {false, false, false, true, true, true, false, true, true, true},
                            {true, true, true, false, false, false, true, false, false, false}};
        int rows = 8;
        int columns = 10;
        Assert.assertEquals(8, CountingIslands.recursiveCount(rows, columns, grid));
    }

    @org.junit.Test
    public void testBiggerLinear() {
        boolean[][] grid = {{true, false, false, false, true, true, false, false, false, false},
                {true, true, false, true, false, true, false, true, true, true},
                {false, true, true, false, false, true, true, false, false, true},
                {true, false, false, false, true, false, false, true, false, true},
                {true, true, true, false, true, true, true, true, false, true},
                {false, true, true, false, false, true, true, false, false, true},
                {false, false, false, true, true, true, false, true, true, true},
                {true, true, true, false, false, false, true, false, false, false}};
        int rows = 8;
        int columns = 10;
        Assert.assertEquals(8, CountingIslands.linearCount(rows, columns, grid));
    }
}
