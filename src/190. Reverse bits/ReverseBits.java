public class ReverseBits {

    /*
     * Second try, cleaner code, instead of using an array to store the bits,
     * i just check the last bit of the number and add it to the sum, then i right shift 
     * the number to check the next bit.
     * 
     * Runtime 0ms beats 100%
     */
    class Solution2 {
        public int reverseBits(int n) {
            int sum = 0;

            for(int i = 31; i>=0; i--){
                if ((n & 1) == 1) sum += 1<<i;
                n >>= 1;
            }
            
            return sum;
        }
    }


    /*
     * First try
     * First i store each bit in the end of an array, then i reconstruct
     * the number using bitwise OR and left shift. (better than pow)
     * Runtime: 1ms beats 56.52%
     */
    class Solution {
        public int reverseBits(int n) {
            int res = 0;
            
            int[] list = new int[32];
            int pos = 31;
            while(pos >= 0){
                list[pos--] = (n&1);
                n >>>= 1;
            }

            for(int i = 0; i<list.length; i++){
                //if(list[i] == 1) res += Math.pow(2,pow);
                if(list[i] == 1) res |= (1 << i);
            }

            return res;
        }
    }
}
