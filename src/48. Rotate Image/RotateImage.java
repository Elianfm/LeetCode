public class RotateImage {

    /*
     * Tranpose then reverse each row
     * 
     * Runtime 0 beats 100%
     */
    class Solution {
        public void rotate(int[][] matrix) {
            int rowLen = matrix.length;
            int colLen = matrix[0].length;

            for(int i = 0; i<rowLen; i++){
                for(int j = i+1; j<colLen; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            int colMidLen = colLen >> 1;
            for(int i = 0; i<rowLen; i++){
                for(int j = 0; j<colMidLen; j++){
                    int newCol = colLen - 1 - j;
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][newCol];
                    matrix[i][newCol] = temp;
                }
            }
        }
    }
}
