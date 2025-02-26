import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating {
    /*
     * First try, using sliding window and hashmap to store the index of the
     * last occurrence of each character.
     * 
     * Runtime: 5ms Beats 87.46%
     * Memory: 44.64MB Beats 67.02
     */

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int max = 0;
            Map<Character, Integer> map = new HashMap<>();

            int left = 0;

            for (int right = 0; right < s.length(); right++) {
                char c = s.charAt(right);

                if (map.containsKey(c) && map.get(c) >= left) {
                    max = Math.max(max, (right - left));
                    left = map.get(c) + 1;
                }

                map.put(c, right);
            }

            return Math.max(max, s.length() - left);
        }
    }
}
