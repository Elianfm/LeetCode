public class Number1Bits {

    /*
     * First try, i thought how i know when a binary is even or odd,
     * so if we keep dividing by 2 and check the remainder, we can count
     * the number of 1's in the binary representation.
     * 
     * Runtime: 0ms beats 100%
     */
    class Solution {
        public int hammingWeight(int n) {
            int count = 0;

            while(n > 0){
                //if(n % 2 == 1) count++;
                count += (n & 1);
                n = n >> 1;
                // n >>>= 1; // unsigned right shift
            }

            return count;
        }
    }
}
