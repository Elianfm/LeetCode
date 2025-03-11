public class MaximalSquare {
    /*
     * First try: DP, it workds but i think it can be cleaner
     * 
     * Runtime: 7ms beats 73.87%
     * Memory: 60.12mb beats 73.87%
     */

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int max = 0;
            int lenRow = matrix.length;
            int lenCol = matrix[0].length;
            int[][] matrixNum = new int[lenRow][lenCol];

            for (int i = 0; i < lenRow; i++) {
                if (matrix[i][0] == '1') {
                    max = 1;
                    matrixNum[i][0] = 1;
                } else {
                    matrixNum[i][0] = 0;
                }

            }

            for (int j = 0; j < lenCol; j++) {
                if (matrix[0][j] == '1') {
                    max = 1;
                    matrixNum[0][j] = 1;
                } else {
                    matrixNum[0][j] = 0;
                }
            }

            /* cleaner version but slower
             * for (int i = 0; i < lenRow; i++) {
             * matrixNum[i][0] = (matrix[i][0] == '1') ? 1 : 0;
             * max = Math.max(max, matrixNum[i][0]);
             * }
             * 
             * for (int j = 0; j < lenCol; j++) {
             * matrixNum[0][j] = (matrix[0][j] == '1') ? 1 : 0;
             * max = Math.max(max, matrixNum[0][j]);
             * }
             */

            for (int i = 1; i < lenRow; i++) {
                for (int j = 1; j < lenCol; j++) {
                    if (matrix[i][j] == '1') {
                        int aCell = matrixNum[i - 1][j - 1];
                        int bCell = matrixNum[i - 1][j];
                        int cCell = matrixNum[i][j - 1];
                        int localMin = Math.min(aCell, Math.min(bCell, cCell));
                        matrixNum[i][j] = (localMin > 0) ? localMin + 1 : 1;
                        max = Math.max(max, matrixNum[i][j]);
                    }
                }
            }

            return (int) Math.pow(max, 2);
        }
    }
}
