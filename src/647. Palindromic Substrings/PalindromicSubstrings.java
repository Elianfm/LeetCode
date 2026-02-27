public class PalindromicSubstrings {


    /*
     * No recursive approach it's a bit faster
     * Runtime 5ms beats 97.16%
     */
    class Solution2 {
        int len;

        public int countSubstrings(String s) {
            this.len = s.length();
            int substrings = len;

            for(int i = 0; i<len; i++){
                substrings += explore(s, i, i+1);
                substrings += explore(s, i-1, i+1);
            }

            return substrings;

        }

        private int explore(String s, int left, int right){
            int count = 0;
            while(left >= 0 && right < len && s.charAt(left) == s.charAt(right)){
                count++;
                left--;
                right++;
            }
            return count;
        }
    }

    /*
     * First try, pretty similar to Longest Palindromic Substring, i explore all the possible centers of the palindromes, 
     * and for each center i explore how many palindromes i can find, when i find a palindrome i add 1 to the count of 
     * palindromic substrings.
     * 
     * Runtime 7ms beats 45.22%
     */
    class Solution {
        int len;

        public int countSubstrings(String s) {
            this.len = s.length();
            int substrings = len;

            for(int i = 0; i<len; i++){
                substrings += explore(s, i, i+1);
                substrings += explore(s, i-1, i+1);
            }

            return substrings;

        }

        private int explore(String s, int left, int right){
            if(left < 0 || right >= len) return 0;
            if(s.charAt(left) != s.charAt(right)) return 0;
            return 1 + explore(s,left-1, right+1);
        }
    }
}