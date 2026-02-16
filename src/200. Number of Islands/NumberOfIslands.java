class NumberOfIslands {

    /*
     * Second try, similar, a bit cleaner
     * Runtime: 2ms beats 99.78%
     */
    class Solution {
        int rowLen;
        int colLen;

        public int numIslands(char[][] grid) {
            rowLen = grid.length;
            colLen = grid[0].length;
            int count = 0;

            for(int i = 0; i<rowLen; i++){
                for(int j = 0; j<colLen; j++){
                    if(grid[i][j] == '1'){
                        explore(grid, i, j);
                        count++;
                    }
                }
            }

            return count;
        }

        private void explore(char[][] grid, int row, int col){
            if(row >= rowLen || col >= colLen || row < 0 || col < 0 ||
                grid[row][col] == '0') return;

            grid[row][col] = '0';

            explore(grid, row+1, col);
            explore(grid, row, col+1);
            explore(grid, row-1, col);
            explore(grid, row, col-1);
        }
    }

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
