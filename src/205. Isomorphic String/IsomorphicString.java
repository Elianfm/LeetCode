import java.util.HashMap;
import java.util.Map;

/* PENDING TO OPTIMIZE */
class IsomorphicString {


    /*
     * First try, i use a hashmap to store the characters and check if the
     * characters are isomorphic. Two options, using charAt or toCharArray
     * 
     * with charAt: (worst performance but less memory)
     * Runtime: 9ms Beats 76.40%
     * Memory: 42.39MB Beats 84.31%
     * 
     * with toCharArray: (best performance but more memory)
     * Runtime: 7ms Beats 86.10%
     * Memory: 43.18MB Beats 7.87%
     */

     public boolean isIsomorphic(String s, String t) {
        if(s.length() != s.length()) return false;

        Map<Character,Character> map = new HashMap<>();


        for(int i = 0; i<s.length(); i++){
            Character a = s.charAt(i);
            Character b = t.charAt(i);

            if(map.containsKey(a)){
                if(map.get(a) != b) return false;
            }else{
                if(map.containsValue(b)) return false;
                map.put(a,b);
            }
        }

        return true;
    }
}
