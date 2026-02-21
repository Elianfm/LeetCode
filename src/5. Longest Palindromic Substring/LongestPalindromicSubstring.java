public class LongestPalindromicSubstring {

    /*
     * Second try
     * Runtime 15ms beats 62.11%
     */
    class Solution {
        int len;

        public String longestPalindrome(String s) {
            
            int maxLong = 0;
            String longestSubstring = "";

            len = s.length();

            for(int i = 0; i<len; i++){
                int uneven = repTimes(s, i-1, i+1);
                int even = repTimes(s, i-1, i);

                int totalUneven = (uneven*2)+1;
                int totalEven = (even*2);

                if(totalUneven > maxLong){
                    maxLong = totalUneven;
                    longestSubstring = s.substring(i-uneven, i+uneven+1);
                }   

                if(totalEven > maxLong){
                    maxLong = totalEven;
                    longestSubstring = s.substring(i-even, i+even);
                } 
            }

            return longestSubstring;

        }

        private int repTimes(String s, int left, int right){
            if(left < 0 || right == len) return 0;
            int actualCount = 0;    

            while (left >= 0 && right < len && s.charAt(left--) == s.charAt(right++))
                actualCount++;
            
            return actualCount;

        }
    }


    /*
     * 
     * Firs try, i looped through the string and select two pointers to move from
     * the center to the sides
     * 
     * Runtime 19ms beats 57.17%
     * Memory: 42.00mb beats 97.79%
     */

    public String longestPalindrome(String s) {
        int max = 0;
        int indexLeft = 0;
        int indexRight = 0;

        for (int i = 0; i < s.length(); i++) {
            int even = movePointers(i, i + 1, s);
            int odd = movePointers(i - 1, i + 1, s);
            int evenElements = even * 2;
            int oddElements = 1 + odd * 2;
            int localMax = Math.max(evenElements, oddElements);

            if (localMax > max) {
                indexLeft = (evenElements > oddElements) ? i - even + 1 : i - odd;
                indexRight = (evenElements > oddElements) ? i + even : i + odd;
                max = Math.max(localMax, max);
            }
        }

        return s.substring(indexLeft, indexRight + 1);
    }

    public int movePointers(int left, int right, String s) {
        if (left < 0 || right >= s.length()) return 0;
        if (s.charAt(left) != s.charAt(right)) return 0;
        return movePointers(left - 1, right + 1, s) + 1;
    }
}
