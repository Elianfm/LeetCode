import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    /*
     * First try, using a hashmap to store the number of characters in s1 and s2.
     * Then, we remove the characters from s2 that are in s1 til the hashmap is empty.
     * If the character is not in s1, we reset the hashmap or move the first position of s2 to the right.
     * This solution is O(n) in time and O(n) in space. But it's slow cause it's using a hashmap, and
     * we can use a fixed size array of 26 elements instead.
     * 
     * Runtime: 24ms beats 39.53%
     * Memory 45.05mb beats 19.11%
     */
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if(s1.length() > s2.length()) return false;
            Map<Character, Integer> numChar = new HashMap<>();
            char[] cs1 = s1.toCharArray();
            char[] cs2 = s2.toCharArray();
    
            for(int i = 0; i<cs1.length; i++){
                char pos = cs1[i];
                numChar.put(pos, 1 + numChar.getOrDefault(pos,0));
            }
    
            Map<Character,Integer> localChar = new HashMap<>(numChar);
            int firstPos = -1;
            for(int i = 0; i<cs2.length; i++){
                char pos = cs2[i];
                if(localChar.containsKey(pos)){
                    if(firstPos < 0) firstPos = i; 
                    localChar.put(pos, localChar.get(pos) - 1);
                    if(localChar.get(pos) == 0) localChar.remove(pos);
                    if(localChar.isEmpty()) return true;
                }else{
                    if(firstPos < 0) continue;
    
                    if(!numChar.containsKey(pos)){
                        localChar.clear();
                        localChar.putAll(numChar);
                        firstPos = -1;
                        continue;
                    }
    
                    char first = cs2[firstPos++];
                    localChar.put(first, 1 + localChar.getOrDefault(first,0));
                    i--;
                    
                }
            }
        
            return false;
        }
    }
}
