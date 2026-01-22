public class TransposeMatrix {


    /*
     * Same as first, but using variables for lengths, maybe a bit faster?
     * 
     * Runtime: 0ms beats 100% (uh?)
     */
    class Solution2 {
        public int[][] transpose(int[][] matrix) {
            int rLen = matrix.length;
            int cLen = matrix[0].length;
            int[][] newMatrix = new int[cLen][rLen];
            
            for(int i = 0; i<rLen;i++){
                for(int j = 0; j<cLen;j++){
                    newMatrix[j][i] = matrix[i][j];
                }
            }

            return newMatrix;
        }
    }

    /*
     * First try, brute force approach!
     * Runtime: 1ms beats 26.62% (uh?)
     */
    class Solution {
        public int[][] transpose(int[][] matrix) {
            int[][] newMatrix = new int[matrix[0].length][matrix.length];
            for(int i = 0; i<matrix.length;i++){
                for(int j = 0; j<matrix[0].length;j++){
                    newMatrix[j][i] = matrix[i][j];
                }
            }

            return newMatrix;
        }
    }
}
