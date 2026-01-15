public class MergeStringsAlternately {

    /*
    * Same solution with stringbuilder
    * Runtime 1ms beats 95.17%
    */
    class Solution2 {
        public String mergeAlternately(String word1, String word2) {
            int idx = 0;
            StringBuilder out = new StringBuilder("");

            int lenWord1 = word1.length();
            int lenWord2 = word2.length();

            while (idx < lenWord1 && idx < lenWord2) {
                out.append(word1.charAt(idx));
                out.append(word2.charAt(idx));
                idx++;
            }

            if (idx < lenWord1) {
                out.append(word1.substring(idx));
            } else {
                out.append(word2.substring(idx));
            }

            return out.toString();
        }
    }

    /*
    * First try, without stringbuilder
    * Runtime 4ms beats 19.84%
    */
    class Solution {
        public String mergeAlternately(String word1, String word2) {
            int idx = 0;
            String out = "";

            int lenWord1 = word1.length();
            int lenWord2 = word2.length();

            while(idx<lenWord1 && idx<lenWord2){
                out += "" + word1.charAt(idx) + word2.charAt(idx);
                idx++;
            }

            if (idx < lenWord1) {
                out += "" + word1.substring(idx);
            } else {
                out += "" + word2.substring(idx);
            }

            return out;
        }
    }
}
