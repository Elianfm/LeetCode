// PENDING TRY TO SOLVE WITHOUT CONVERTING TO STRING
public class PalindromeNumber {

    /*
     * THIRD TRY - I use a math approach to reverse the number and compare it with
     * the original.
     * It's faster, but i saw there's a way to reverse only half of the number.
     * So it can be improved.
     * RUNTIME 5ms - Beats 72.12%
     * MEMORY 43.84MB - Beats 71.80%
     */

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int inverse = 0;
        int flag = x;

        // I can extract the last digit with x%10
        // To be able to extract next digit i can just
        // divide in 10 and convert to int, this will
        // cut previous digit. And every steep in the loop
        // i just multiply by 10 and and next digit.
        // In this way i can get the inverse number.

        while (flag > 0) {
            // i multiply previous digit by 10 and add next digit
            inverse = (inverse * 10) + (flag % 10);

            // i cut current digit
            flag = flag / 10;
        }
        return (x == inverse);
    }

    /*
     * SECOND TRY - I use a StringBuilder to reverse the number and compare it with
     * the original.
     * It's slow anyway, but cleaner.
     * Runtime 7ms - Beats 16.44%
     * Memory 44.20MB - Beats 34.66%
     */

    /*
     * public boolean isPalindrome(int x) {
     * StringBuilder num = new StringBuilder(Integer.toString(x));
     * return (num.toString().equals(num.reverse().toString()));
     * }
     */

    /*
     * FIRST TRY - I use two pointers and convert the integer to a string.
     * It works but its slow.
     * Runtime: 6ms - Beats 30.33%
     * Memory 44.00MB - Beats 71.80%
     */

    /*
     * public boolean isPalindrome(int x) {
     * String num = Integer.toString(x);
     * int start = 0;
     * int end = num.length()-1;
     * 
     * while(end >= start){
     * if(num.charAt(start++) != num.charAt(end--)) return false;
     * }
     * return true;
     * }
     */

}
