/* PENDING TO IMPROVE */
class NumberOfIslands {

    /*
     * First try, i just explored the grid and when i found a 1,
     * i explored all the adjacent 1s and set them to 0 and incremented the islands counter.
     * It was a success, but i think it can be improved.
     * Runtime: 3ms Beats 86.56%
     * Memory: 49.63 Beats 52.50%
     */

    private char[][] grid;
    private int islands;
    private int width;
    private int height;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.islands = 0;

        this.height = grid.length;
        this.width = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    toZero(i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void toZero(int i, int j) {
        grid[i][j] = '0';

        // top
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            toZero(i - 1, j);
        }

        // down
        if (i + 1 < height && grid[i + 1][j] == '1') {
            toZero(i + 1, j);
        }

        // left
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            toZero(i, j - 1);
        }

        // right
        if (j + 1 < width && grid[i][j + 1] == '1') {
            toZero(i, j + 1);
        }
    }
}
