/* PENDING RETRY */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /*
     * Second try, this time i use memoization to store the results of the
     * recursive calls with a hashset.
     * 
     * Runtime: 8ms beats 44.42%
     * Memory: 44.83mb 22.03%
     */

    class Solution2{

        Set<String> memo = new HashSet();

        public boolean wordBreak(String s, List<String> wordDict) {
            if (memo.contains(s))
                return false;
            if (s.length() == 0)
                return true;
            String temp = s;

            for (int i = 1; i <= s.length(); i++) {
                String subs = s.substring(0, i);
                if (wordDict.contains(subs)) {
                    if (wordBreak(s.substring(i), wordDict)) {
                        return true;
                    }
                }
            }

            memo.add(s);
            return false;
        }
    }

    /*
     * First try, using a recursive approach, i loop through the string and check if
     * the substring from 0 to i is in the wordDict and repeat the process.
     * I got TLE, so i should try a different approach
     * 
     * Runtime: TLE
     */

    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s.length() == 0)
                return true;
            String temp = s;

            for (int i = 1; i <= s.length(); i++) {
                String subs = s.substring(0, i);
                if (wordDict.contains(subs)) {
                    if (wordBreak(s.substring(i), wordDict))
                        return true;
                }
            }

            return false;
        }
    }
}
