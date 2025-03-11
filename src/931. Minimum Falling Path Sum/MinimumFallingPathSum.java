public class MinimumFallingPathSum {
    /*
     * First try, using DP to solve the problem. 
     * But its still slow
     * 
     * Runtime 6ms beats 70.93%
     * Memory: 45.11 beats 84.30%
     */
    class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int lenRow = matrix.length;
            int lenCol = matrix[0].length;

            for (int i = 1; i < lenRow; i++) {
                for (int j = 0; j < lenCol; j++) {
                    int a = (j - 1 == -1) ? Integer.MAX_VALUE : matrix[i - 1][j - 1];
                    int b = matrix[i - 1][j];
                    int c = (j + 1 == lenCol) ? Integer.MAX_VALUE : matrix[i - 1][j + 1];

                    //matrix[i][j] += Math.min(a, Math.min(b, c)); // 7ms
                    int minLocal = (a < b) ? a : b;
                    matrix[i][j] += (minLocal < c) ? minLocal : c;

                }
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lenCol; i++) {
                min = Math.min(min, matrix[lenRow - 1][i]);
            }

            return min;
        }
    }
}
