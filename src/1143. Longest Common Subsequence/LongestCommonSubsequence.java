public class LongestCommonSubsequence {

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
