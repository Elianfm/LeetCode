public class CountingBits {

    // Pending do it in linear time single pass (follow up question)

    /*
     * First try, i thought to use the same logic as in
     * 191. Number of 1 Bits problem, i got a O(n log n) solution
     * 
     * Runtime: 3ms Beats 32.28%
     */
    class Solution {
        public int[] countBits(int n) {
            int[] out = new int[n+1];

            for(int i = 0; i<n+1; i++)
                out[i] = numberBits(i);
            
            return out;
        }

        private int numberBits(int n){
            int count = 0;
            while(n > 0){
                count += (n & 1);
                n >>= 1;
            }
            return count;

        }
    }
}
