public class GreatestCommonDividorStrings {

    /*
     * Second try, euclidian algorithm, i found this approach in the discussion,
     * so after some days after the first try, i decided to give it a try, and it worked.
     * 
     * Runtime: 1ms beats 91.51%
     */
    class Solution3 {
        public String gcdOfStrings(String str1, String str2) {
            String str3 = str1 + str2;
            String str4 = str2 + str1;
            if(!str3.equals(str4)) return "";

            int common = euclidian(str1.length(), str2.length());
            return str3.substring(0,common);
        }


        private int euclidian(int s1, int s2){
            int mod = s1 % s2;
            return (mod == 0) ? s2 : euclidian(s2, mod);
        }

    }

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
