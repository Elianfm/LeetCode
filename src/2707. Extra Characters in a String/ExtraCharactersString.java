import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExtraCharactersString {

    /*
     * In this try, i use a recursive approach, exploring all the possible combinations of the string, 
     * and checking if the prefix is in the dictionary, if it is, i can skip it, if it isn't, i have to 
     * add the length of the prefix to the result. I also use a memoization map to avoid exploring the 
     * same substring multiple times.
     * 
     * Runtime: 138ms beats 5.22%
     */
    class Solution {
        Set<String> dict;
        Map<String, Integer> memo;

        public int minExtraChar(String s, String[] dictionary) {
            dict = new HashSet<>();
            memo = new HashMap<>();

            for(String st: dictionary)
                dict.add(st);

            return explore(s,0,s.length());
        }

        private int explore(String s, int left, int right){
            if(left >= right) return 0;
            
            String actual = s.substring(left,right);
            if(memo.containsKey(actual)) return memo.get(actual);

            int res = right - left;
            for(int i = left+1; i <= right; i++){
                String prefix = s.substring(left,i);

                if(dict.contains(prefix)){
                    res = Math.min(res, explore(s,i,right));
                }else{
                    res = Math.min(res, prefix.length() + explore(s,i,right));
                }
            }


            memo.put(actual, res);
            return res;
        }
    }

    // First try, greedy approach, i failed miserably
}
