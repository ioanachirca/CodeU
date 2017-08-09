import java.util.HashSet;

/**
 * Created by ioana-chirca on 09-Jun-17.
 */
public class WordSearch {
    public static HashSet<String> findWords(int rows, int columns, char[][] letterGrid, Dictionary dictionary) {
        HashSet<String> found = new HashSet<>();
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                search(rows, columns, letterGrid, x, y, dictionary, found, "");
            }
        }
        return found;
    }

    private static void search(int rows, int columns, char[][] letterGrid, int x, int y,
                               Dictionary dictionary, HashSet<String> found, String word) {
        // DFS-style search over the grid


        if (dictionary.isWord(word)) {
            found.add(word);
        }

        if (!dictionary.isPrefix(word) || letterGrid[x][y] == '-') {
            // visited cells are marked with '-' in order not to use them twice
            return;
        }

        if (dictionary.isPrefix(word + letterGrid[x][y])) {
            word += letterGrid[x][y];
            char c = letterGrid[x][y]; // saving the original letter in order to restore it later
            letterGrid[x][y] = '-'; // mark as visited

            int[] dx = {-1, 0, 1};
            int[] dy = {-1, 0, 1};
            for (int i = 0; i < dx.length; i++) {
                for (int j = 0; j < dy.length; j++) {
                    int neighX = x + dx[i];
                    int neighY = y + dy[j];
                    if (0 <= neighX && neighX < rows && 0 <= neighY && neighY < columns) {
                        // adjacent cell is in range, we will visit it
                        search(rows, columns, letterGrid, neighX, neighY, dictionary, found, word);
                    }
                }
            }

            letterGrid[x][y] = c; // restoring the original letter
        }
    }

}
