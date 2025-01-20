import java.util.HashSet;
import java.util.Set;

class ValidSudoku {

    /*
     * Second try, optimized with boolean arrays
     * Runtime: 1ms Beats 100%
     * Memory: 44.78MB Beats 41.05%
     */

    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') continue;

                int num = value - '1';
                int blockIndex = (i / 3) * 3 + (j / 3);

                if (rows[i][num] || columns[j][num] || blocks[blockIndex][num]) return false;
                
                rows[i][num] = true;
                columns[j][num] = true;
                blocks[blockIndex][num] = true;
            }
        }

        return true;
    }

    /*
     * First try, it works but is slow
     * Runtime: 14ms Beats 17.97%
     * Memory: 44.72MB Beats 41.05%
     */

    /*
     * public boolean isValidSudoku(char[][] board) {
     * Set seen = new HashSet<>();
     * 
     * for(int i = 0; i<9; i++){
     * for(int j=0; j<9; j++){
     * char value = board[i][j];
     * if(value == '.') continue;
     * if(!seen.add("row" + i + "-" + value)
     * || !seen.add("column" + j + "" + value)
     * || !seen.add("block" + i/3 + "" + j/3 + "" + value))
     * return false;
     * }
     * }
     * return true;
     * }
     */

}
