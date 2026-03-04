import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    /*
     * Second try, using sliding window and a fixed size array of 26 elements to store the number of characters in s1 and s2.
     * First we fill the array with the number of characters in s1, then we fill the first window of s2 and check if the array is all zeros.
     * (If its all zeros, it means that the first window of s2 is a permutation of s1). Then we move the window to the right and update 
     * the array accordingly until we find a window that is a permutation of s1 or we reach the end of s2.
     * 
     * Runtime: 4ms beats 99.54%
     */
    class Solution2 {
        public boolean checkInclusion(String s1, String s2) {
            int len1 = s1.length();
            int len2 = s2.length();
            if(len1 > len2) return false;

            int[] letters = new int[26];

            for(int i = 0; i<len1; i++)
                letters[s1.charAt(i) - 'a']++;
            
            for(int i = 0; i<len1; i++)
                letters[s2.charAt(i) - 'a']--;
        
            if(allZeros(letters)) return true;
            for(int i = len1; i<len2; i++){
                letters[s2.charAt(i) - 'a']--;
                letters[s2.charAt(i-len1) - 'a']++;
                if(allZeros(letters)) return true;
            }

            return false;
        }

        private boolean allZeros(int[] letters){
            for(int i: letters) if(i != 0) return false;
            return true;
        }
    }

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
