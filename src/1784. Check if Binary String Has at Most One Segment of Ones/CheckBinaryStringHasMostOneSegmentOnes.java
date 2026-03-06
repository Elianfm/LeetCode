public class CheckBinaryStringHasMostOneSegmentOnes {


    /*
     * Cleaner solution, without casting the char to int
     * Runtime 0ms beats 100%
     */
    class Solution {
        public boolean checkOnesSegment(String s) {
            for(int i = 1; i<s.length(); i++)
                if(s.charAt(i-1) == '0' && s.charAt(i)  == '1') return false;

            return true;
        }
    }

    /*
     * First try, every string s start with 1, so we can ignore the first char, then we need to check if
     * there is a 0 and after that a 1, if that happens we return false, otherwise we return true
     * 
     * Runtime: 0ms beats 100%
     */
    class Solution {
        public boolean checkOnesSegment(String s) {
            
            boolean firstZero = false;
            for(int i = 1; i<s.length(); i++){
                int actual = s.charAt(i) - '0';
                if(!firstZero){  
                    if(actual == 0) firstZero = true;
                }else{
                    if(actual == 1) return false;
                }
            }

            return true;
        }
    }
}
