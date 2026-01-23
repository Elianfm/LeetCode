public class PlusOne {

    /*
     * Cleaned up version of my first try
     */
    class Solution2 {
        public int[] plusOne(int[] digits) {
            int len = digits.length;

            for(int i = len-1; i>=0; i--){
                if(digits[i] < 9){
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }

            int[] newDigits = new int[len + 1];
            newDigits[0] = 1;
            return newDigits;
            
        }
    }

    /*
     * First try, straightforward approach, loop from the end, add one,
     * if it's less than nine return, else set to zero and continue. If
     * we finish the loop and the first digit is zero, we need to create
     * a new array with length + 1, set first digit to one and copy the rest.
     * 
     * Runtime 0ms beats 100%
     */
    class Solution {
        public int[] plusOne(int[] digits) {
            int len = digits.length;

            for(int i = len-1; i>=0; i--){
                if(digits[i] < 9){
                    digits[i]++;
                    return digits;
                }
                digits[i] = 0;
            }

            if(digits[0]==0){
                int[] newDigits = new int[len + 1];
                newDigits[0] = 1;
                
                for(int i = 1; i<newDigits.length; i++)
                    newDigits[i] = digits[i-1];
                
                return newDigits;
            }
            return digits;
        }
    }
}
