public class CountingBits {


    /*
     * Third try, follow up single pass O(n)
     * Runtime 2ms beats 96.51%
     */
    class Solution3 {
        public int[] countBits(int n) {
            int[] nums = new int[n+1];

            for(int i = 0; i<=n; i++)
                nums[i] = (i & 1) + nums[(i >> 1)];
            
            return nums;
        }
    }

    /*
     * Second try, similar but without recursion
     * Runtime: 2ms beats 96.43%
     */
    class Solution2 {
        public int[] countBits(int n) {
            int[] ans = new int[n+1];

            for(int i = 0; i<ans.length; i++){
                int temp = i;
                int sum = 0;
                while(temp > 0){
                sum += temp & 1;
                temp >>= 1;
                }
                ans[i] = sum;
            }

            return ans;
        }
    }

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
