public class ReverseString {

    /*
    * First try, simple two pointer swap 
    * Runtime: 0ms beats 100%
    */
    class Solution {
        public void reverseString(char[] s) {
            int last = s.length - 1;
            int middle = s.length/2;
            for(int i = 0; i<middle; i++){
                char temp = s[last];
                s[last--] = s[i];
                s[i] = temp;
            }

        }
    }
}
