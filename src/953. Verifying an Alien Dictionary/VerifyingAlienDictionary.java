import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary {

    /*
     * Second, similar to first but using arrays instead of map for better performance.
     * Runtime: 0ms beats 100.00%
     */
    class Solution2 {
        int[] alphabet = new int[26];

        public boolean isAlienSorted(String[] words, String order) {
            for(int i = 0; i<order.length(); i++)
                alphabet[order.charAt(i) - 'a'] = i;

            for(int i = 1; i<words.length; i++)
                if(!check(words[i-1], words[i], 0)) return false;

            return true;
        }

        private boolean check(String word1, String word2, int pos){
            if(pos >= word1.length()) return true;
            if(pos >= word2.length()) return false;

            char char1 = word1.charAt(pos);
            char char2 = word2.charAt(pos);
            if(char1 == char2) return check(word1, word2, pos+1);
            return alphabet[char1-'a'] < alphabet[char2-'a'];
        }
    }

    /*
     * First try, first i add the alien alphabet to a map with the position
     * of each character, then i compare each word with the next one checking
     * the characters one by one.
     * 
     * Runtime: 1ms beats 60.30%
     */
    class Solution {
        Map<Character, Integer> alphabet = new HashMap<>();

        public boolean isAlienSorted(String[] words, String order) {
            for(int i = 0; i<order.length(); i++){
                alphabet.put(order.charAt(i), i);
            }

            for(int i = 1; i<words.length; i++){
                if(!check(words[i-1], words[i], 0)) return false;
            }

            return true;
        }

        private boolean check(String word1, String word2, int pos){
            if(pos >= word1.length()) return true;
            if(pos >= word2.length()) return false;

            char char1 = word1.charAt(pos);
            char char2 = word2.charAt(pos);
            if(char1 == char2) return check(word1, word2, pos+1);
            return alphabet.get(char1) < alphabet.get(char2);
        }
    }
}
