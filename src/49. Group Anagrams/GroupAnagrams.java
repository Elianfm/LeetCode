import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    /*
     * Second try, i order the string and use it as a key and a pointer to the
     * index of the list as a value
     * 
     * Runtime: 6ms beats 97.91%
     * Memory: 47.88mb beats 69.44%
     * 
     */
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> output = new ArrayList<>();
            Map<String,Integer> memo = new HashMap<>();
            int pointer = 0;

            for(int i = 0; i<strs.length; i++){
                String word = strs[i];

                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String res = String.valueOf(chars);


                int localPointer = pointer;
                if(memo.containsKey(res)){
                    localPointer = memo.get(res);
                } else{
                    output.add(new ArrayList<>());
                    memo.put(res,pointer);
                    pointer++;
                }

                output.get(localPointer).add(word);
            }

            return output;
        }
    }

    /*
     * First try, i tried to use isAnagram from 242. Valid Anagram
     * but it was sooo slow
     * 
     * Runtime: 430ms beats 5.04%
     * Memory 47.90mb beats 90.92%
     */

     class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> anagrams = new ArrayList<>();
            List<String> actualWords = new ArrayList<>();
            boolean[] visitedStr = new boolean[strs.length];
    
            for(int i = 0; i<strs.length; i++){
                actualWords.clear();
                if(visitedStr[i]) continue;
                String actualA = strs[i];
                actualWords.add(actualA);
    
                for(int j = i+1; j<strs.length; j++){
                    String actualB = strs[j];
                    if(visitedStr[j]) continue;
                    if(isAnagram(actualA, actualB)){
                        actualWords.add(actualB);
                        visitedStr[j] = true;
                    }
                }
                anagrams.add(new ArrayList<>(actualWords));
            }
    
            return anagrams;
        }
    
        public boolean isAnagram(String s, String t) {
            // fromo 242. Valid Anagram
            int len = s.length();
            if(len != t.length()) return false;
            int[] counter = new int[26];
    
            for(int i = 0; i<len; i++){
                int c = s.charAt(i)-97;
                counter[c] += 1;            
            }
    
            for(int  i = 0; i<len; i++){
                int c = t.charAt(i)-97;
                int remain = counter[c];
                if(remain < 1) return false;
                counter[c]--;
            }
    
            return true;
    
        }
    
    }
}
