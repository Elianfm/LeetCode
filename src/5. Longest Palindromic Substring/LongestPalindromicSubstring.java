public class LongestPalindromicSubstring {

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
