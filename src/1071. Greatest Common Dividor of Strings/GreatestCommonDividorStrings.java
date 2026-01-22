public class GreatestCommonDividorStrings {

    // pending to solve with euclidean algorithm

    /*
     * First try, after a lot of failed submissions, i got this approach.
     * I saw string doc and found a useful method regionMatches that
     * helped me to compare substrings without creating new strings.
     * Runtime: 1ms beats 90.42%
     */
    class Solution {
        public String gcdOfStrings(String str1, String str2) {
            int right = str2.length();

            while(right > 0){
                if(str1.length() % right == 0 
                    && str2.length() % right == 0){
                    boolean isValid = true;
                    for(int i = 0; i<str1.length(); i+=right){
                        if(!str1.regionMatches(i,str2, 0,right))
                            isValid = false;
                    }
                    for(int i = 0; i<str2.length(); i+=right){
                        if(!str2.regionMatches(i,str2, 0,right))
                            isValid = false;
                    }
                    if(isValid) return str2.substring(0,right);
                }
                right--;
            }

            return "";
        }
    }
}
