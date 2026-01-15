public class ValidPalindromeII {

    /*
    * Recursion, it works, its legible, but its slow
    * Runtime: 15ms beats 5.21ms
    */
   class Solution2 {
        public boolean validPalindrome(String s) {
            int left = 0;
            int right = s.length()-1;
            return check(s, left, right, false);
        }


        private boolean check(String s, int left, int right, boolean deleted){
            if(left>=right) return true;
            
            if(s.charAt(left) == s.charAt(right)) return check(s, left+1, right-1, deleted);
            if(deleted) return false;

            return check(s, left+1, right, true)
                || check(s, left, right-1, true);
        }
    }


    /*
    * First try, two pointers, i check for a mismatch, and then check if the rest of the string
    * is a palindrome removing either the left or the right character. i think i can optimize it
    * using recursion
    * 
    * Runtime: 4ms beats 99.69%
    */

    class Solution {
        public boolean validPalindrome(String s) {
            int left = -1;
            int right = s.length();

            while(++left<--right){
                if(s.charAt(left) != s.charAt(right))
                    return check(s, left+1, right) || check(s, left, right-1);
            }

            return true;
        }


        private boolean check(String s, int left, int right){
            while(left<right)
                if(s.charAt(left++) != s.charAt(right--))
                    return false;
            return true;
        }
    }
}