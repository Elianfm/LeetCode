public class Search2DMatrix {


    /*
     * First try, binary search approach.
     * I thought of the matrix as a 1D array, and then I can use binary search to
     * find the target.
     * 
     * Runtime: 0ms beats 100%
     * Memory: 41.99mb beats 91.68%
     */
    class Solution {
        int rows;
        int columns;

        public boolean searchMatrix(int[][] matrix, int target) {
            this.rows = matrix.length;
            this.columns = matrix[0].length;
            if (rows == 0) return false;
            return binarySearch(matrix, target, 0, rows * columns - 1);
        }

        private boolean binarySearch(int[][] matrix, int target, int left, int right) {
            if (left > right) return false;

            int mid = (left + right) / 2;
            int column = mid % columns;
            int row = mid / columns;

            int num = matrix[row][column];
            if (num == target) return true;

            return (target < num)
                    ? binarySearch(matrix, target, left, mid - 1)
                    : binarySearch(matrix, target, mid + 1, right);

        }

    }


    /*
     * Just trying things, i found linear approach works as well, 
     * and leetcode takes it as runtime 0ms too lol
     * Runtime 0ms beats 100%
     */
    class SolutionLinear {
        public boolean searchMatrix(int[][] matrix, int target) {
            for(int i = 0; i<matrix.length; i++)
                for(int j=0; j<matrix[0].length; j++)
                    if(target == matrix[i][j]) return true;

            return false;
        }
    }
}
