public class MinimumPathSum {
    /*
     * First try, i realized i can sum every cell selecting the minimum if it's not the first row or column.
     * like this;
     * 
     *  1  3  1     1  4  5      1  4  5      1  4  5     1  4  5
     *  1  5  1  => 2  5  1  =>  2  7  1  =>  2  7  6 =>  2  7  6
     *  4  2  1     6  2  1      6  2  1      6  8  1     6  8  7
     * 
     * so its DP.
     * 
     * Runtime: 3ms beats 75.03%
     * Memory: 47.35mb beats 89.14%  
     */

     class Solution {
        public int minPathSum(int[][] grid) {
            int lenA = grid.length;
            int lenB = grid[0].length;
    
            for (int i = 1; i < lenA; i++) {
                grid[i][0] += grid[i - 1][0];
            }
    
            for (int i = 1; i < lenB; i++) {
                grid[0][i] += grid[0][i - 1];
            }
    
            for (int i = 1; i < lenA; i++) {
                for (int j = 1; j < lenB; j++) {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
                }
            }
    
            return grid[lenA-1][lenB-1];
    
        }
    }
}
