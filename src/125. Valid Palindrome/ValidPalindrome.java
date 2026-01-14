public class ValidPalindrome {
    /*
    * Secon try, in this i use direct ascii values to compare characters
    * Runtime: 2ms beats 98.68%
    */
    class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length()-1;

            while(left<right){

                int charLeft = s.charAt(left);
                int charRight = s.charAt(right);

                if(!isAlphaNumeric(charLeft)){
                    left++;
                    continue;
                }

                if(!isAlphaNumeric(charRight)){
                    right--;
                    continue;
                }

                charLeft = toMinus(charLeft);
                charRight = toMinus(charRight);

                if(charLeft != charRight) return false;
                left++;
                right--;
            }

            return true;

        }

        public boolean isAlphaNumeric(int ch){
            return (ch >= 65 && ch <= 90)
            || (ch >= 97 && ch <= 122)
            || (ch >= 48 && ch <= 57);
        }

        public int toMinus(int ch){
            return (ch >= 65 && ch <= 90) ? ch+32: ch;
        }
    }



    // first try
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        int first = 0;
        int last = s.length() - 1;

        while (first <= last) {

            if (!Character.isLetterOrDigit(s.charAt(first))) {
                first++;
                continue;
            }

            if (!Character.isLetterOrDigit(s.charAt(last))) {
                last--;
                continue;
            }

            if (s.charAt(first++) != s.charAt(last--)) {
                return false;
            }

        }

        return true;
    }
}
