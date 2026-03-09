import java.util.Arrays;

public class LongestCommonSubsequence {

    // pending to try bottom up approach

    /*
     * Second try, again exploring every possible path but this time i use memoization to save the results of the explored paths, 
     * so if i encounter the same path again, i can just return the saved result instead of exploring it again. 
     * Top down approach 
     * 
     * Runtime: 25ms beats 29.93%
     */    
    class Solution2 {
        int n;
        int m;

        public int longestCommonSubsequence(String text1, String text2) {
            this.n = text1.length();
            this.m = text2.length();
            int[][] memo = new int[n][m];
            
            for(int i = 0; i<memo.length;i++)
                Arrays.fill(memo[i],-1);

            return longest(text1,text2,0,0,memo);

        }

        private int longest(String text1, String text2, int oneIdx, int twoIdx, int[][] memo){
            if(oneIdx >= n || twoIdx >= m) return 0;
            if(memo[oneIdx][twoIdx] != -1) return memo[oneIdx][twoIdx];

            int res = (text1.charAt(oneIdx) == text2.charAt(twoIdx))
                ? 1 + longest(text1, text2, oneIdx+1, twoIdx+1, memo)
                : Math.max(
                    longest(text1, text2, oneIdx+1, twoIdx, memo),
                    longest(text1, text2, oneIdx, twoIdx+1, memo)
                ); 

            memo[oneIdx][twoIdx] = res;
            return res;

        }
    }

    /*
     * First try, exploring every possible path, if the characters are equal, i increase the count and move both pointers, 
     * if not, i move one of the pointers and explore both options, the best one is the answer.
     * 
     * Runtime TLE
     */
    class Solution {
        int lenText1;
        int lenText2;

        public int longestCommonSubsequence(String text1, String text2) {
            lenText1 = text1.length();
            lenText2 = text2.length();
            return explore(text1, text2, 0,0);
        }

        private int explore(String text1, String text2, int pos1, int pos2){
            if(pos1 == lenText1 || pos2 == lenText2) return 0;

            if(text1.charAt(pos1) == text2.charAt(pos2))
                return 1 + explore(text1, text2, pos1+1, pos2+1);

            return Math.max(
                explore(text1, text2, pos1+1, pos2),
                explore(text1, text2, pos1, pos2+1)
            );
        }
    }
}
