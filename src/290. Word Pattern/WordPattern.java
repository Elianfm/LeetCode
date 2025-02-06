import java.util.HashMap;
import java.util.Map;

class WordPattern {

    /* First try
     * Using hashmap to store the characters and separate the words
     * with split method, pretty similar to IsomorphicString.java
     * 
     * Runtime: 0ms Beats 100%
     * Memory: 42.04MB Beats 5.84%
     */

     public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] words = s.split(" ");
        char[] c = pattern.toCharArray();

        if (c.length != words.length) return false;

        for (int i = 0; i < c.length; i++) {
            if (map.containsKey(c[i])) {
                if (!map.get(c[i]).equals(words[i])) return false;
            } else {
                if(map.containsValue(words[i])) return false;
                map.put(c[i], words[i]);
            }
        }

        return true;

    }

}
