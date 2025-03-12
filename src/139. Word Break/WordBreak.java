/* PENDING RETRY */
public class WordBreak {

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
                    if (wordBreak(s.substring(i), wordDict)) return true;
                }
            }

            return false;
        }
    }
}
