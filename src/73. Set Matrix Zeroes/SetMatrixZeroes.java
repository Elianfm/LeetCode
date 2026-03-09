public class SetMatrixZeroes {

    /*
     * Simpler version of first try, with memo but without Node class and setZeroes methods
     * i use directly the memo arrays to check which rows and columns should be set to zero, 
     * and then i iterate over the matrix again and set the corresponding rows and columns to zero.
     * 
     * Runtime: 1ms beats  61.21%
     */
    class Solution3 {
        boolean[] memoRow;
        boolean[] memoCol;

        public void setZeroes(int[][] matrix) {
            this.memoRow = new boolean[matrix.length];
            this.memoCol = new boolean[matrix[0].length];


            for(int i = 0; i<matrix.length;i++)
                for(int j = 0; j<matrix[0].length; j++)
                    if(matrix[i][j] == 0)
                        memoRow[i] = memoCol[j] = true;
            

            for(int i = 0; i<memoRow.length; i++)
                if(memoRow[i])
                    for(int j = 0; j<matrix[0].length; j++)
                        matrix[i][j] = 0;
            
            for(int i = 0; i<memoCol.length; i++)
                if(memoCol[i])
                    for(int j = 0; j<matrix.length; j++)
                        matrix[j][i] = 0;   
                
        }

    }
    
    /*
     * First try, with memoization. Idea is simple, first i find all the zeroes in the matrix and save their positions, 
     * then i iterate over the list of zeroes and set the corresponding rows and columns to zero, but before setting them to zero,
     * i check if they have already been set to zero before using the memoization arrays, if they have been set to zero before, 
     * i skip them.
     * 
     * Runtime: 1ms beats  61.21%
     */
    class Solution2 {
        boolean[] memoRow;
        boolean[] memoCol;

        public void setZeroes(int[][] matrix) {
            this.memoRow = new boolean[matrix.length];
            this.memoCol = new boolean[matrix[0].length];

            List<Node> zeroes = new ArrayList<>();

            for(int i = 0; i<matrix.length;i++)
                for(int j = 0; j<matrix[0].length; j++)
                    if(matrix[i][j] == 0) zeroes.add(new Node(i,j));
                

            for(int i = 0; i<zeroes.size();i++){
                Node z = zeroes.get(i);
                matrix = setZeroRowCol(matrix,z.row,z.col);
            }

        }

        private int[][] setZeroRowCol(int[][] matrix, int row, int col){
            if(!memoCol[col]){
                for(int i = 0; i<matrix.length; i++)
                    matrix[i][col] = 0;
                memoCol[col] = true;
            }

            if(!memoRow[row]){
                for(int i = 0; i<matrix[0].length; i++)
                    matrix[row][i] = 0;
                memoRow[row] = true;
            }

            return matrix;
        }

        private class Node{
            int row;
            int col;

            public Node(int row, int col){
                this.row = row;
                this.col = col;
            }
        }

    }

    /*
     * First try, without memoization (just to compare the runtime)
     * Runtime: 13ms beats 3.34%
     */
    class Solution {
        boolean[] memoRow;
        boolean[] memoCol;

        public void setZeroes(int[][] matrix) {
            this.memoRow = new boolean[matrix.length];
            this.memoCol = new boolean[matrix[0].length];

            List<Node> zeroes = new ArrayList<>();

            for(int i = 0; i<matrix.length;i++)
                for(int j = 0; j<matrix[0].length; j++)
                    if(matrix[i][j] == 0) zeroes.add(new Node(i,j));
                

            for(int i = 0; i<zeroes.size();i++){
                Node z = zeroes.get(i);
                matrix = setZeroRowCol(matrix,z.row,z.col);
            }

        }

        private int[][] setZeroRowCol(int[][] matrix, int row, int col){
            for(int i = 0; i<matrix.length; i++)
                matrix[i][col] = 0;

            for(int i = 0; i<matrix[0].length; i++)
                matrix[row][i] = 0;
        
            return matrix;
        }

        private class Node{
            int row;
            int col;

            public Node(int row, int col){
                this.row = row;
                this.col = col;
            }
        }

    }
}
