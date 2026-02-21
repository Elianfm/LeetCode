public class MaxAreaIsland {

    /*
     * Second version, same idea but in-place marking the explored cells as 0 
     * instead of using a separate boolean array.
     * Its faster but it modifies the input grid
     * 
     * Runtime 1ms beats 100%
     */

    class Solution2 {
        int lenRow;
        int lenCol;

        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            lenRow = grid.length;
            lenCol = grid[0].length;

            for(int i = 0; i<grid.length; i++)
                for(int j = 0; j<grid[0].length; j++)
                    if(grid[i][j] == 1)
                        maxArea = Math.max(maxArea, findArea(grid, i, j));

            return maxArea;
            
        }

        private int findArea(int[][] grid, int row, int col){
            if(col < 0 || row < 0 || row >= lenRow || col >= lenCol 
                || grid[row][col] == 0) return 0;

            grid[row][col] = 0;

            return 1 + findArea(grid, row+1, col)
                            + findArea(grid, row-1, col)
                            + findArea(grid, row, col+1)
                            + findArea(grid, row, col-1);
        }
    }

    /*
     * First try, pretty similar to 200. Number of Islands, 
     * but instead of counting the number of islands, we count the area 
     * of each island and return the max.
     * 
     * Runtime 2ms beats 67.38%
     */
    class Solution {
        boolean[][] explored;
        int lenRow;
        int lenCol;

        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            lenRow = grid.length;
            lenCol = grid[0].length;
            explored = new boolean[lenRow][lenCol];

            for(int i = 0; i<grid.length; i++)
                for(int j = 0; j<grid[0].length; j++)
                    if(grid[i][j] == 1 && !explored[i][j])
                        maxArea = Math.max(maxArea, findArea(grid, i, j));

            return maxArea;
            
        }

        private int findArea(int[][] grid, int row, int col){
            if(col < 0 || row < 0 || row >= lenRow || col >= lenCol 
                || grid[row][col] == 0 || explored[row][col]) return 0;

            explored[row][col] = true;

            return 1 + findArea(grid, row+1, col)
                            + findArea(grid, row-1, col)
                            + findArea(grid, row, col+1)
                            + findArea(grid, row, col-1);
        }
    }
}
