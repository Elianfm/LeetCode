import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestRepeatinCharacterReplacement {


    /*
     * Second try, sliding window, it was a little confusing at first,
     * but once i understood the logic, it was easy to implement, the idea is to keep track of the most frequent 
     * character in the window, and if the window size is greater than the most frequent character plus k, 
     * then we need to shrink the window from the left.
     * 
     * Runtime 7ms beats 88.61%
     * 
     */
    class Solution {
    public int characterReplacement(String s, int k) {
        int[] window = new int[26];

        int left = 0;
        int maxWindow = 0;

        int max = 0;
        for(int i = 0; i<s.length(); i++){
            int posActual = s.charAt(i) - 'A';
            window[posActual]++;
            maxWindow = Math.max(maxWindow, window[posActual]);

            while(i - left + 1 > maxWindow + k){ // for some reason while is faster than if
                int posLeft = s.charAt(left++) - 'A';
                window[posLeft]--;
            }

            max = Math.max(max, i - left + 1);
            
        }

        return max;
    }
}


    /*
     * First try, i use a set to store all the characters in the string, then i
     * use a queue to store the index of the characters that are not equal to the
     * current character, and use a variable to store the last replacement index.
     * In this way, i can get the length of the longest substring that can be
     * replaced. It's slow, but it works.
     * 
     * Runtime: 46ms beats 11.13%
     * Memory: 47.64 beats 7.49%
     * 
     */
    public int characterReplacement(String s, int k) {

        Set<Character> characters = new HashSet<>();
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            characters.add(s.charAt(i));
        }

        for (char c : characters) {
            Queue<Integer> window = new LinkedList<>();
            int first = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c)
                    continue;

                if (window.size() == k) {
                    max = Math.max(max, i - first);
                    first = (k == 0) ? i + 1 : window.poll() + 1;
                }

                if (k > 0) window.add(i);
            }
            max = Math.max(max, s.length() - first);
        }

        return max;

    }
}
