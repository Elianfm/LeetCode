import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LongestRepeatinCharacterReplacement {

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
