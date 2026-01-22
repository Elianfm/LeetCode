public class ReverseBits {
    /*
     * First try, i dont like bitwise e_e
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
