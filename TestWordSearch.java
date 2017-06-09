import org.junit.Assert;
import java.util.HashSet;

/**
 * Created by ioana-chirca on 09-Jun-17.
 */
public class TestWordSearch {
    private WordSearch wordSearch = new WordSearch();
    private Dictionary dictionary;
    private char[][] letterGrid;

    @org.junit.Test
    public void test1() {
        String[] words = {"CAR", "CARD", "CART", "CAT"};
        dictionary = new Dictionary(words);
        char[][] grid = {{'A', 'A', 'R'}, {'T', 'C', 'D'}};
        letterGrid = grid;
        HashSet<String> result = new HashSet<>();
        result.add("CAR");
        result.add("CARD");
        result.add("CAT");

        HashSet<String> found = wordSearch.findWords(2, 3, letterGrid, dictionary);
        Assert.assertTrue(found.equals(result));
    }

    @org.junit.Test
    public void test2() {
        String[] words = {"ABBY", "BYE", "BABY", "ERROR", "RORY", "BOOZE", "ZERO", "SIBLING", "BLING", "OLD"};
        dictionary = new Dictionary(words);
        char[][] grid = {{'A', 'L', 'O', 'L', 'I', 'N', 'G'},
                        {'D', 'B', 'B', 'Z', 'E', 'R', 'O'},
                        {'X', 'I', 'Y', 'R', 'O', 'R', 'Y'},
                        {'S', 'X', 'E', 'R', 'R', 'O', 'R'}};
        letterGrid = grid;
        HashSet<String> result = new HashSet<>();
        result.add("ABBY");
        result.add("BYE");
        result.add("ERROR");
        result.add("RORY");
        result.add("ZERO");
        result.add("SIBLING");
        result.add("BLING");
        result.add("OLD");

        HashSet<String> found = wordSearch.findWords(4, 7, letterGrid, dictionary);
        Assert.assertTrue(found.equals(result));
    }

}
