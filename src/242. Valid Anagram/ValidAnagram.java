import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*
     * Second try, using int array to store the frequency of each character in the string.
     * ASCII code of 'a' is 97, so we can use c-97 to get the index of the character in the array.
     * 
     * Runtime 2ms beats 97.75%
     */

     class Solution2{
        public boolean isAnagram(String s, String t) {
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


    /*
     * First try, using HashMap to store the frequency of each character in the string.
     * 
     * Runtime 16ms beats 23.18%
     */

     class Solution {
        public boolean isAnagram(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            if(s.length() != t.length()) return false;
    
            for(int i = 0; i<s.length(); i++){
                Character c = s.charAt(i);
                map.put(c, map.getOrDefault(c,0)+1);
            }
    
            for(int  i = 0; i<t.length(); i++){
                Character c = t.charAt(i);
                int remain = map.getOrDefault(c, -1);
    
                if(remain > 0){
                    map.put(c, map.getOrDefault(c,0)-1);
                } else{
                    return false;
                }
            }
    
            return true;
    
        }
    }
}
