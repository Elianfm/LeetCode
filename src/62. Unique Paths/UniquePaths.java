
 // Pending a solution with less space complexity 
public class UniquePaths {


    /*
     * Third try, i realize the number of paths is similar to Pascal's triangle
     * then i simulate the triangle over a 2d array and use dp to get the result
     * (i saw someone use this approach in a interview and got rejected
     * for using O(mxn) space, but i think it's a good approach for learning dp)
     * 
     * Runtime: 0ms beats 100%
     * Memory: 40.22mb beats 87.59%
     */
    class Solution {

        /*
         * 0  1  1  1
         * 1  2  3  4
         * 1  3  6 10
         * 1  4 10 20 <------ pascal
         */

        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }

            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - 1];
                }
            }

            return dp[m - 1][n - 1];
        }
    }

    /*
     * Second try, i simplify the code, i still got tle lol
     * 
     */
    class Solution2 {
        int mEnd;
        int nEnd;

        public int uniquePaths(int m, int n) {
            this.mEnd = m - 1;
            this.nEnd = n - 1;
            return walk(0, 0);
        }

        private int walk(int mPos, int nPos) {
            if (mPos == mEnd || nPos == nEnd)
                return 1;
            return walk(mPos + 1, nPos) + walk(mPos, nPos + 1);
        }
    }

    /*
     * First try, i confuse cause i thought it was all possible paths
     * and not only when going right and down, but after putting
     * just right and down, i got tle.
     */

    class Solution {

        int mEnd;
        int nEnd;
        // boolean[][] board;

        public int uniquePaths(int m, int n) {
            this.mEnd = m - 1;
            this.nEnd = n - 1;
            // board = new boolean[m][n];

            return walk(0, 0);
        }

        private int walk(int mPos, int nPos) {
            // if(mPos < 0 || nPos < 0) return 0;
            if (mPos > mEnd || nPos > nEnd)
                return 0;
            // if(board[mPos][nPos]) return 0;
            if (mPos == mEnd && nPos == nEnd)
                return 1;

            // board[mPos][nPos] = true;

            int paths = 0;
            paths += walk(mPos + 1, nPos);
            paths += walk(mPos, nPos + 1);
            // paths += walk(mPos-1, nPos);
            // paths += walk(mPos, nPos-1);

            // board[mPos][nPos] = false;

            return paths;
        }
    }
}
