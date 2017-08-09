import java.util.HashMap;

/**
 * Created by ioana-chirca on 22-Jun-17.
 */
public class CountingIslands {
    public static int recursiveCount(int rows, int columns, boolean[][] grid) {
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(grid[i][j])  {
                    DFS(rows, columns, grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    private static void DFS(int rows, int columns, boolean[][] grid, int x, int y) {
        grid[x][y] = false;
        int[] dx = {-1, 0, 1};
        int[] dy = {-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newX = x + dx[i];
                int newY = y + dy[j];
                // if neighbour is not in range or is on the diagonal, abort
                if (newX < 0 || newX >= rows || newY < 0 || newY >= columns || dx[i] * dy[j] != 0) continue;
                if (grid[newX][newY]) DFS(rows, columns, grid, newX, newY);
            }
        }
    }

    private static Cell root(Cell cell, HashMap<Cell, Cell> disjointSet) {
        while (disjointSet.get(cell) != cell) {
            cell = disjointSet.get(cell);
        }
        return cell;
    }

    public static int linearCount(int rows, int columns, boolean[][] grid) {
        HashMap<Cell, Cell> disjointSet = new HashMap<>();
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j]) {
                    Cell cell = new Cell(i, j);
                    // check west and north neighbors - they are the ones visited already
                    Cell north = null;
                    Cell west = null;
                    if (j > 0 && grid[i][j-1]) west = new Cell(i, j - 1);
                    if (i > 0 && grid[i-1][j]) north = new Cell(i - 1, j);
                    if (north != null && west != null) {
                        // there are two islands nearby, so we merge with them
                        // if they were two different islands, we decrease the number of islands
                        Cell northRoot = root(north, disjointSet);
                        Cell westRoot = root(west, disjointSet);
                        if (northRoot != westRoot) {
                            islands--;
                        }
                        disjointSet.put(cell, north);
                    } else if (north != null) {
                        // we join the north island
                        disjointSet.put(cell, north);
                    } else if (west != null) {
                        // we join the west island
                        disjointSet.put(cell, west);
                    } else {
                        // no adjacent islands
                        disjointSet.put(cell, cell);
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        boolean[][] grid = {{false, true, false, true},
                {true, true, false, false},
                {false, false, true, false},
                {false, false, true, false}};
        int rows = 4;
        int columns = 4;
        //System.out.println(recursiveCount(rows, columns, grid));
        System.out.println(linearCount(rows, columns, grid));
    }
}

class Cell {
    public int x;
    public int y;

    public Cell() {}
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object object) {
        if (object instanceof Cell) {
            return x == ((Cell)object).x && y == ((Cell)object).y;
        }
        return false;
    }

    public String toString() {
        return x + " - " + y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
